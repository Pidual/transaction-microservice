package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.application.mapper.SupplyMapper;
import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;

import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.infrastructure.output.feign.IStockServicePort;
import feign.FeignException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISuppliesHandler {

    private final ISupplyServicePort supplyUseCase;
    private final IStockServicePort feignClient;
    private final SupplyMapper supplyMapper;

    @Override
    public void addSupplies(SupplyRequestDTO supplyDTO, String token, String email) {
        Supply supply = supplyMapper.toSupply(supplyDTO);
        supply.setUserEmail(email);

        supplyUseCase.addSuppliesToArticle(supply);

        try {
            feignClient.updateArticleQuantity(token, supplyDTO);
        } catch (Exception e) {
            throw new FeignClientException("MICROSERVICIO DE STOCK ESTA APAGADO!");
        }


    }





}
