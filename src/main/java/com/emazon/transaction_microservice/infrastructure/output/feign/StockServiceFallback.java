package com.emazon.transaction_microservice.infrastructure.output.feign;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class StockServiceFallback implements IStockServicePort{

    @Override
    public void updateArticleQuantity(String token, SupplyRequestDTO request) {
        System.err.println("Stock service is unavailable. Could not update article quantity for: " + request.getArticleName());
    }
}
