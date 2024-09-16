package com.emazon.transaction_microservice.infrastructure.output.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service", url = "http://stock-service")
public interface IStockFeignClient {

    @PutMapping("/api/articles/{id}/quantity")
    void updateArticleQuantity(@PathVariable("id") Long articleId, @RequestParam("quantity") Integer quantity);
}
