package com.emazon.transaction_microservice.infrastructure.configuration;


import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.domain.spi.ISupplyPersistencePort;
import com.emazon.transaction_microservice.domain.usecase.SupplyUseCase;
import com.emazon.transaction_microservice.infrastructure.output.jpa.adapter.SupplyJpaAdapter;
import com.emazon.transaction_microservice.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infrastructure.output.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    public ISupplyPersistencePort suppliesPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }




}
