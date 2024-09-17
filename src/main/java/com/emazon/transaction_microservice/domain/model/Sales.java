package com.emazon.transaction_microservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sales {

    private Long id;  // Identificador de la venta
    private String clientEmail;  // Correo del cliente
    private List<SaleItem> items;  // Lista de artículos vendidos
    private LocalDateTime saleDate;  // Fecha de la venta
    private BigDecimal totalCost;  // Costo total de la venta
    private String status;  // Estado de la venta (completada, fallida, etc.)
    private LocalDateTime lastModifiedDate;  // Fecha de última modificación de la venta


    public Sales(Long id, String clientEmail, List<SaleItem> items, LocalDateTime saleDate, BigDecimal totalCost, String status, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.clientEmail = clientEmail;
        this.items = items;
        this.saleDate = saleDate;
        this.totalCost = totalCost;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
