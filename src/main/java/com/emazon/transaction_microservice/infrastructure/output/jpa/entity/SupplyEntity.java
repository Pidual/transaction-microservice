package com.emazon.transaction_microservice.infrastructure.output.jpa.entity;

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
    private Long id;

    @Column(nullable = false)
    private String  articleName;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private LocalDateTime supplyDate;

    @Column(nullable = false)
    private String userEmail;
}
