package com.emazon.transaction_microservice.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyRequestDTO {

    @NotBlank(message = "El nombre del artículo es obligatorio")
    private String articleName;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int quantity;

}
