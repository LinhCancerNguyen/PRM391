package com.example.project.data.db;

import android.content.Context;
import android.net.ConnectivityManager;

import androidx.room.FtsOptions;
import androidx.room.Room;

import com.example.project.data.model.Account;
import com.example.project.data.model.Orders;
import com.example.project.data.model.Pet;
import com.example.project.data.model.Product;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SyncData {
    private DBConnection dbConnection;
    private FirebaseFirestore db;
    private Account account;
    private boolean connected;

    public SyncData(Context context) {
        dbConnection = Room.databaseBuilder(context, DBConnection.class,"PetShop.db")
                .allowMainThreadQueries() //should remove
                .build();
        db = FirebaseFirestore.getInstance();
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        connected = manager.getActiveNetworkInfo()!=null && manager.getActiveNetworkInfo().isConnected();
    }

    public void Synchronize() {
        if (connected) {
            new ProductSync().start();
            new PetSync().start();
            new OrderSync().start();
        }
    }

    public Account Authen(Account acc){
        account = acc;
        new AccountSync().start();
        try {
            this.wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return account;
    }

    private class AccountSync extends Thread {
        @Override
        public void run() {
            AccountDAO accountDAO = dbConnection.getAccountDAO();
            Account temp = accountDAO.get(account.getId());
            if (temp != null){
                account = temp;
            } else if (connected) {
                Task<QuerySnapshot> task = db.collection("account")
                        .whereEqualTo("email", account.getEmail())
                        .whereEqualTo("password", account.getPassword())
                        .get();
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Account a = new Account(document.getId(), document.getData());
                        if (a != null) {
                            accountDAO.update(a);
                        }
                    }
                }
            }
            SyncData.this.notify();
        }
    }

    private class ProductSync extends Thread {
        @Override
        public void run() {
            ProductDAO productDAO = dbConnection.getProductDAO();
            Task<QuerySnapshot> task = db.collection("product").get();
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Product p = new Product(document.getId(), document.getData());
                    Product temp = productDAO.get(p.getId());
                    if (temp == null){
                        productDAO.insert(p);
                    } else {
                        productDAO.update(p);
                    }
                }
            }
        }
    }

    private class PetSync extends Thread {
        @Override
        public void run() {
            PetDAO petDAO = dbConnection.getPetDAO();
            Task<QuerySnapshot> task = db.collection("pet").get();
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Pet p = new Pet(document.getId(), document.getData());
                    Pet temp = petDAO.get(p.getId());
                    if (temp == null){
                        petDAO.insert(p);
                    } else {
                        petDAO.update(p);
                    }
                }
            }
        }
    }

    private class OrderSync extends Thread {
        @Override
        public void run() {
            OrderDAO orderDAO = dbConnection.getOrderDAO();
            Task<QuerySnapshot> task = db.collection("order").get();
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Orders p = new Orders(document.getId(), document.getData());
                    Orders temp = orderDAO.get(p.getId());
                    if (temp == null){
                        orderDAO.insert(p);
                    } else {
                        orderDAO.update(p);
                    }
                }
            }
        }
    }
}
