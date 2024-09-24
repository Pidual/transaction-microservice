package com.emazon.transaction_microservice.infrastructure.configuration;


import com.emazon.transaction_microservice.application.handler.ISuppliesHandler;
import com.emazon.transaction_microservice.application.handler.SupplyHandler;
import com.emazon.transaction_microservice.application.mapper.SupplyMapper;
import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.domain.spi.ISupplyPersistencePort;
import com.emazon.transaction_microservice.domain.usecase.SupplyUseCase;
import com.emazon.transaction_microservice.infrastructure.output.feign.IStockServicePort;
import com.emazon.transaction_microservice.infrastructure.output.jpa.adapter.SupplyJpaAdapter;
import com.emazon.transaction_microservice.infrastructure.output.jpa.mapper.SupplyEntityMapper;
import com.emazon.transaction_microservice.infrastructure.output.jpa.repository.ISupplyRepository;
import com.emazon.transaction_microservice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository; //repo
    private final SupplyEntityMapper supplyEntityMapper; //mapper

    private final IStockServicePort stockServiceFeignClient;
    private final SupplyMapper supplyMapper;
    private final JwtService jwtService;

    //Supply DOMAIN / API
    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(suppliesPersistencePort());
    }

    @Bean
    public ISupplyPersistencePort suppliesPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISuppliesHandler suppliesHandler() {
        return new SupplyHandler(supplyServicePort(),stockServiceFeignClient,supplyMapper);
    }




}
