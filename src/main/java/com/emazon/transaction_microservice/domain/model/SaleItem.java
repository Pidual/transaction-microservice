package com.emazon.transaction_microservice.domain.model;

import java.math.BigDecimal;

public class SaleItem {

    private Long articleId;             // ID del artículo vendido
    private String articleName;         // Nombre del artículo
    private int quantity;               // Cantidad de artículos vendidos
    private BigDecimal unitPrice;       // Precio unitario del artículo
    private BigDecimal totalPrice;      // Precio total (quantity * unitPrice)

}
