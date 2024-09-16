package com.emazon.transaction_microservice.infraestructure.output.jpa.adapter;


import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.domain.spi.ISuppliesPersistencePort;
import com.emazon.transaction_microservice.infraestructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infraestructure.output.jpa.repository.SupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISuppliesPersistencePort {

    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupplies(Supply supply) {
        // W H A T I M D O O I N N G G G G G


    }

    @Override
    public void getSupplies(Long id) {
        // I D O  N T K  N OW
    }


}
