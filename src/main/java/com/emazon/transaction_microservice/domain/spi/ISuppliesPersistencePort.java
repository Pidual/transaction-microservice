package com.emazon.transaction_microservice.domain.spi;

import com.emazon.transaction_microservice.domain.model.Supply;

import java.util.List;

public interface ISuppliesPersistencePort {

    void saveSuppliesTransaction(Supply supply);
    List<Supply> getAllSupplies();

    //void saveTransaccion();
}
