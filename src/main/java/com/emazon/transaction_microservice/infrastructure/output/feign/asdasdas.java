package com.emazon.transaction_microservice.infrastructure.output.feign;

import com.emazon.transaction_microservice.domain.spi.IStockServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceFeignAdapter implements IStockServicePort {

    private final StockFeignClient stockFeignClient;

    @Autowired
    public StockServiceFeignAdapter(StockFeignClient stockFeignClient) {
        this.stockFeignClient = stockFeignClient;
    }

    @Override
    public void updateArticleQuantity(Long articleId, Integer quantity) {
        stockFeignClient.updateArticleQuantity(articleId, quantity);
    }
}
