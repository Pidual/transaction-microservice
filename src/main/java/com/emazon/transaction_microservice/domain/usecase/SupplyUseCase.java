package com.emazon.transaction_microservice.domain.usecase;

import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.domain.spi.ISuppliesPersistencePort;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISuppliesPersistencePort suppliesJpaAdapter;

    public SupplyUseCase(ISuppliesPersistencePort suppliesPersistencePort) {
        this.suppliesJpaAdapter = suppliesPersistencePort;
    }


    @Override
    public void addSupplies() {
        // validar que los suministros esten bien (metodo)

        // si el suministro es esta null o algo raro tirar excepciones

        //

        // TODO document why this method is empty
    }

    @Override
    public Supply getSupplies() {
        return null;
    }
}