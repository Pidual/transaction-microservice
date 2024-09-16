package com.emazon.transaction_microservice.infrastructure.input;


import com.emazon.transaction_microservice.application.handler.ISuppliesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplies")
@RequiredArgsConstructor
@Validated
public class SuppliesController {

    private final ISuppliesHandler suppliesHandler;






}
