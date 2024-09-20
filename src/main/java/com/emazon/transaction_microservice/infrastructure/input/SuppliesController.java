package com.emazon.transaction_microservice.infrastructure.input;


import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.application.handler.ISuppliesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/supplies")
@RequiredArgsConstructor
@Validated
public class SuppliesController {

    private final ISuppliesHandler suppliesHandler;

    @PreAuthorize("hasAnyRole('AUX_BODEGA')")
    @PostMapping("/add-supplies")
    public ResponseEntity<Void> addSupply(@RequestBody SupplyRequestDTO supply) {
        suppliesHandler.addSupplies(supply);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
