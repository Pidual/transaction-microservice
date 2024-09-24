package com.emazon.transaction_microservice.domain.model;


import java.time.LocalDateTime;

public class Supply {

    private String articleName;
    private int quantity;
    private LocalDateTime supplyDate;
    private String userEmail;


    public Supply(String articleName, int quantity, String userEmail) {
        this.articleName = articleName;
        this.quantity = quantity;
        this.supplyDate = LocalDateTime.now();
        this.userEmail = userEmail;
    }


    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDateTime supplyDate) {
        this.supplyDate = supplyDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
