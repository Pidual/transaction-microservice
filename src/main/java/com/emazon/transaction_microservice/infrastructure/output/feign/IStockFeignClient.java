package com.emazon.transaction_microservice.infrastructure.output.feign;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.infrastructure.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "stock-service",
        url = "http://localhost:8090/articles",
        configuration = FeignClientConfig.class
)
public interface IStockFeignClient {

    @PatchMapping("/add-stock")
    void updateArticleQuantity(@RequestHeader("Authorization") String token, @RequestBody SupplyRequestDTO request);
}
