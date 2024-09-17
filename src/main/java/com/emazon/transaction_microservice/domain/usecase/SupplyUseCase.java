package com.emazon.transaction_microservice.domain.usecase;

import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.domain.exceptions.DataBaseErrorJpa;
import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.domain.spi.ISuppliesPersistencePort;
import jakarta.transaction.Transactional;

import java.util.List;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISuppliesPersistencePort suppliesJpaAdapter;
    

    public SupplyUseCase(ISuppliesPersistencePort suppliesPersistencePort) {
        this.suppliesJpaAdapter = suppliesPersistencePort;
    }

    @Override
    @Transactional
    public void addSuppliesToArticle(Supply supply) {
        validateSupply(supply);
        try {
            suppliesJpaAdapter.saveSuppliesTransaction(supply);  // Registrar el suministro en la base de datos local
        } catch (Exception e) {
            throw new DataBaseErrorJpa("Error al agregar suministros: " + e.getMessage()); // Si ocurre un error, lanzar una excepción para que la transacción se revierta
        }
    }


    /**
     * i do this for debugging purpuses
     */
    @Override
    public List<Supply> getSupplies() {
        return suppliesJpaAdapter.getAllSupplies();  // Implementación para obtener la lista de suministros si es necesario
    }



    private void validateSupply(Supply supply) {
        // Validar que el suministro no sea null
        if (supply == null) {
            throw new IllegalArgumentException("El suministro no puede ser null.");
        }

        // Validar que el ID del artículo es válido
        if (supply.getArticleId() == null || supply.getArticleId() <= 0) {
            throw new IllegalArgumentException("El ID del artículo es inválido.");
        }

        // Validar que la cantidad es positiva
        if (supply.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad de suministro debe ser positiva.");
        }
    }
}