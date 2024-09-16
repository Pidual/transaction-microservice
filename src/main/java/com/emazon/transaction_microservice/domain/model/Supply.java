package com.emazon.transaction_microservice.domain.model;


import java.time.LocalDateTime;

public class Supply {

    private Long id; // id de la transaccion
    private Long articleId;
    private int quantity;
    private LocalDateTime fechaTransaccion;
    private Long usuarioId;

    public Supply(Long id, Long usuarioId, LocalDateTime fechaTransaccion, int quantity, Long articleId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaTransaccion = fechaTransaccion;
        this.quantity = quantity;
        this.articleId = articleId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
