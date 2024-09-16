package com.emazon.transaction_microservice.domain.api;

import com.emazon.transaction_microservice.domain.model.Supply;

public interface ISupplyServicePort {

    void addSupplies();

    Supply getSupplies();

}
