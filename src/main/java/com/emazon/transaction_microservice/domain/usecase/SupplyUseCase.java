package com.emazon.transaction_microservice.domain.usecase;

import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
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

        try {
            // Registrar el suministro en la base de datos local
            suppliesJpaAdapter.saveSupplies(supply);


            // Actualizar el stock del artículo en el microservicio de stock FEIN FEIN FEIGN FEIGN
            stockServicePort.updateArticleQuantity(supply.getArticleId(), supply.getQuantity());
            suppliesJpaAdapter.saveTransaccion();

        } catch (Exception e) {
            // Si ocurre un error, lanzar una excepción para que la transacción se revierta
            throw new RuntimeException("Error al agregar suministros: " + e.getMessage(), e);
        }

    }

    @Override
    public List<Supply> getSupplies() {
        // Implementación para obtener la lista de suministros si es necesario
        return suppliesPersistencePort.getAllSupplies();
    }
}