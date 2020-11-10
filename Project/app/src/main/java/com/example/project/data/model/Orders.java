package com.example.project.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.Map;

enum OrderStatus{NOT_PAID, PROCESSING, ACCEPTED, DELIVER, RECEIVED, SUCCESS, CANCEL, EXPIRED, ROLL_BACK}

@Entity
public class Orders {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String accountID;
    @ColumnInfo
    private String productID;
    @ColumnInfo
    @TypeConverters(DateConverter.class)
    private Date dateOrder;
    @ColumnInfo
    private long status;

    public Orders() {
    }

    public Orders(int id, String accountID, String productID, Date dateOrder, long status) {
        this.id = id;
        this.accountID = accountID;
        this.productID = productID;
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public Orders(int id, Map<String, Object> data) {
        this.id = id;
        this.accountID = data.getOrDefault("accountID", "None").toString();
        this.productID = data.getOrDefault("productID", "None").toString();
        this.dateOrder = ((Timestamp) data.getOrDefault("dateOrder", "0")).toDate();
        this.status = (long) data.getOrDefault("status", "-1");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.values()[(int)status];
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
