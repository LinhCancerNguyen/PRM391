package com.example.project.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.Map;

enum OrderStatus{NOT_PAID, PROCESSING, ACCEPTED, DELIVER, RECEIVED, SUCCESS, CANCEL, EXPIRED, ROLL_BACK}

@Entity
public class Orders {
    @PrimaryKey
    private String id;
    @ColumnInfo
    private String accountID;
    @ColumnInfo
    private String productID;
    @ColumnInfo
    private Date dateOrder;
    @ColumnInfo
    private OrderStatus status;

    public Orders() {
    }

    public Orders(String id, Map<String, Object> data) {
        this.id = id;
        this.accountID = data.getOrDefault("accountID", "None").toString();
        this.productID = data.getOrDefault("productID", "None").toString();
        this.dateOrder = (Date) data.getOrDefault("dateOrder", "None");
        this.status = (OrderStatus) data.getOrDefault("status", "None");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
