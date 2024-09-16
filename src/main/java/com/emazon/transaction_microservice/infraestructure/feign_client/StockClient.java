package com.emazon.transaction_microservice.infraestructure.feign_client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", url = "http://stock-service")
public interface StockClient {

    @PutMapping("/articulos/{id}/cantidad")
    ResponseEntity<Void> actualizarCantidad(@PathVariable("id") Long id, @RequestBody ActualizarCantidadRequest request);
}

public class ActualizarCantidadRequest {
    private int cantidad;
    // getters y setters
}
