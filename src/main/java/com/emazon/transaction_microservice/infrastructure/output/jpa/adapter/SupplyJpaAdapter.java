package com.emazon.transaction_microservice.infrastructure.output.jpa.adapter;


import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.domain.spi.ISuppliesPersistencePort;
import com.emazon.transaction_microservice.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


/**
 * This claas communicates wityh the spi package that is in DOMAIN
 * It has the implementations of how to use the database I guess
 */
@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISuppliesPersistencePort {

    private final ISupplyRepository ISupplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;


    @Override
    public void saveSuppliesTransaction(Supply supply) {

    }

    @Override
    public List<Supply> getAllSupplies() {
        return List.of();
    }
}
