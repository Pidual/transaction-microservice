package com.emazon.transaction_microservice.domain.model;


import java.time.LocalDateTime;

public class Supply {

    private Long id; // id de la transaccion
    private Long articuloId;
    private int cantidad;
    private LocalDateTime fechaTransaccion;
    private Long usuarioId;

    // getters y setters


}
