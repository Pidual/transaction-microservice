package com.emazon.transaction_microservice.infrastructure.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "http://localhost:8090") // Cambia el URL al de tu microservicio real
public interface IStockFeignClient {

    @PostMapping("/stock/update/{articleId}/{quantity}")
    void updateArticleQuantity(@PathVariable("articleId") String articleName, @PathVariable("quantity") Integer quantity);
}
