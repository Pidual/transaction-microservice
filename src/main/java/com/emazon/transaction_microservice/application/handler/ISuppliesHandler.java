package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;

public interface ISuppliesHandler {

    void addSupplies(SupplyRequestDTO user);

}
