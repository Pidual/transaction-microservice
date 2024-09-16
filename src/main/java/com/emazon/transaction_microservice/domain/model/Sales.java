package com.emazon.transaction_microservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sales {

    private Long id;                    // ID de la venta (único)
    private Long customerId;             // ID del cliente que realizó la compra
    private LocalDateTime saleDate;      // Fecha y hora de la venta
    private BigDecimal totalAmount;      // Monto total de la venta
    private List<SaleItem> items;        // Lista de artículos vendidos
    private String paymentMethod;        // Método de pago (tarjeta, efectivo, etc.)
    private String status;               // Estado de la venta (completada, fallida, pendiente)
    private String transactionId;        // ID de la transacción de pago
    private Long userId;                 // Usuario que procesó la venta (por ejemplo, el admin)


    public BigDecimal calculateTotalAmount() {
//        return items.stream()
//                .map(SaleItem::getTotalPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
