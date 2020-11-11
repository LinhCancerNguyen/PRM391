package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.R;
import com.example.project.data.db.AccountDAO;
import com.example.project.data.db.DBConnection;
import com.example.project.data.db.PetDAO;
import com.example.project.data.db.ProductDAO;
import com.example.project.data.model.Account;
import com.example.project.data.model.Pet;
import com.example.project.data.model.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnSignIn;
    private DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        db = Room.databaseBuilder(getApplicationContext(), DBConnection.class, "database.db")
                .allowMainThreadQueries()
                .build();

        AccountDAO accountDAO = db.getAccountDAO();
        PetDAO petDAO = db.getPetDAO();
        ProductDAO productDAO = db.getProductDAO();

        List<Account> accounts = accountDAO.all();
        List<Pet> pets = petDAO.all();
        List<Product> products = productDAO.all();

        if(accounts.size() == 0) {
            accountDAO.insert(new Account("test", "test@gmail.com", "test", "0123456789")
                    , new Account("admin", "admin@gmail.com", "admin", "0123456789")
                    , new Account("dev", "dev@gmail.com", "dev", "0123456789"));
        }

        if(pets.size() == 0) {
            petDAO.insert(new Pet("Dogs"), new Pet("Cats"), new Pet("Birds"), new Pet("Fish"), new Pet("Others"));
        }

        if(products.size() == 0) {
            List<Pet> list = petDAO.all();
            productDAO.insert(
                    new Product("Dog Food", "Dog food is a specialty food for domesticated animals that is formulated according to their nutritional needs. Pet food generally consists of meat, meat byproducts, cereals, grain, vitamins, and minerals.", list.get(0).getId(), 100000, "C:\\Users\\LinhCancerNguyen\\Desktop\\PRM391\\PRM391\\Project\\app\\src\\main\\res\\drawable-v24\\category_1.png"),
                    new Product("Cat Food", "Cat food is a specialty food for domesticated animals that is formulated according to their nutritional needs. Pet food generally consists of meat, meat byproducts, cereals, grain, vitamins, and minerals.", list.get(1).getId(), 100000, "C:\\Users\\LinhCancerNguyen\\Desktop\\PRM391\\PRM391\\Project\\app\\src\\main\\res\\drawable-v24\\category_2.png"),
                    new Product("Bird Food", "Bird food is a specialty food for domesticated animals that is formulated according to their nutritional needs. Pet food generally consists of meat, meat byproducts, cereals, grain, vitamins, and minerals.", list.get(2).getId(), 100000, "C:\\Users\\LinhCancerNguyen\\Desktop\\PRM391\\PRM391\\Project\\app\\src\\main\\res\\drawable-v24\\category_3.png"),
                    new Product("Fish Food", "Fish food is a specialty food for domesticated animals that is formulated according to their nutritional needs. Pet food generally consists of meat, meat byproducts, cereals, grain, vitamins, and minerals.", list.get(3).getId(), 100000, "C:\\Users\\LinhCancerNguyen\\Desktop\\PRM391\\PRM391\\Project\\app\\src\\main\\res\\drawable-v24\\category_4.png")
            );
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActitity.class);
                startActivity(intent);
            }
        });
    }
}

