package com.emazon.transaction_microservice.domain.model;

import java.math.BigDecimal;

public class SaleItem {

    private Long articleId;  // Identificador del artículo
    private String articleName;  // Nombre del artículo
    private int quantity;  // Cantidad de artículos vendidos
    private BigDecimal price;  // Precio unitario del artículo

    // Constructor, getters y setters
    public SaleItem(Long articleId, String articleName, int quantity, BigDecimal price) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters y Setters
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(quantity));  // Precio total por artículo
    }
}
