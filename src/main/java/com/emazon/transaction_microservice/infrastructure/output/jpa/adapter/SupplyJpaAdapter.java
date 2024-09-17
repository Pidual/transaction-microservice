package com.emazon.transaction_microservice.infrastructure.output.jpa.adapter;


import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.domain.spi.ISupplyPersistencePort;
import com.emazon.transaction_microservice.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository jpaRepository;
    private final SupplyEntityMapper supplyEntityMapper;


    @Override
    public void saveSupplies(Supply supply) {
        jpaRepository.save(supplyEntityMapper.toEntity(supply));

    }

    @Override
    public List<Supply> getAllSupplies() {
        return List.of();
    }
}
