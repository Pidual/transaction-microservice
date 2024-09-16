package com.emazon.transaction_microservice.domain.model;


import java.time.LocalDateTime;

public class Supply {

    private Long id; // id de la transaccion
    private Long articuloId;
    private int cantidad;
    private LocalDateTime fechaTransaccion;
    private Long usuarioId;

    public Supply(Long id, Long usuarioId, LocalDateTime fechaTransaccion, int cantidad, Long articuloId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaTransaccion = fechaTransaccion;
        this.cantidad = cantidad;
        this.articuloId = articuloId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Long articuloId) {
        this.articuloId = articuloId;
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
