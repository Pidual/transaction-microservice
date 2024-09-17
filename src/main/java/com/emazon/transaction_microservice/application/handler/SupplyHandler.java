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

    private final ISupplyServicePort supplyUseCase;
    //private final IStockFeignClient stockServiceFeignClient;
    private final SupplyMapper supplyMapper;



    @Override
    public void addSupplies(SupplyRequestDTO supplyDTO) {

        supplyUseCase.addSuppliesToArticle(supplyMapper.toSupply(supplyDTO));


        //stockServiceFeignClient.updateArticleQuantity("token idk where i got it",supplyDTO);
    }



}
