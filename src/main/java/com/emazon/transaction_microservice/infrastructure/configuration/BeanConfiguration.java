package com.emazon.transaction_microservice.infrastructure.configuration;


import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.domain.spi.ISuppliesPersistencePort;
import com.emazon.transaction_microservice.domain.usecase.SupplyUseCase;
import com.emazon.transaction_microservice.infrastructure.output.jpa.adapter.SupplyJpaAdapter;
import com.emazon.transaction_microservice.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository; //repo
    private final SupplyEntityMapper supplyEntityMapper; //mapper

    //Suply Configuration
    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(suppliesPersistencePort());
    }

    @Bean
    public ISuppliesPersistencePort suppliesPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }


}
