package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.application.mapper.SupplyMapper;
import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import com.emazon.transaction_microservice.infrastructure.output.feign.IStockFeignClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISuppliesHandler {


    private final ISupplyServicePort supplyUseCase; //useCase
    private final IStockFeignClient stockServiceFeignClient;  //Feing to call another microservice
    private final SupplyMapper supplyMapper; //mapper

    @Override
    public void addSupplies(SupplyRequestDTO supplyDTO) {
        supplyUseCase.addSuppliesToArticle(supplyMapper.toSupply(supplyDTO)); //Validates the article and saves the transacction
        stockServiceFeignClient.updateArticleQuantity(supplyDTO.getArticleName(),supplyDTO.getQuantity());
    }


}
