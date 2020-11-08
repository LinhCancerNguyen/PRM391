package com.example.project.data;

import java.sql.Date;

enum OrderStatus{NOT_PAID, PROCESSING, ACCEPTED, DELIVER, RECEIVED, SUCCESS, CANCEL, EXPIRED, ROLL_BACK}

public class Order {
    private String id;
    private String accountID;
    private String productID;
    private Date dateOrder;
    private OrderStatus status;

    public Order() {
    }

    public Order(String id, String accountID, String productID, Date dateOrder, OrderStatus status) {
        this.id = id;
        this.accountID = accountID;
        this.productID = productID;
        this.dateOrder = dateOrder;
        this.status = status;
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
