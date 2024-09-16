package com.emazon.transaction_microservice.infraestructure.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "supplies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                   // Identificador único de la transacción de suministro

    @Column(nullable = false)
    private Long articleId;             // ID del artículo al que se le está aumentando el suministro

    @Column(nullable = false)
    private int quantity;               // Cantidad de suministro añadida

    @Column(nullable = false)
    private LocalDateTime supplyDate;   // Fecha en la que se realizó el suministro

    @Column(nullable = false)
    private Long userId;                // ID del usuario (aux_bodega) que realizó el suministro
}
