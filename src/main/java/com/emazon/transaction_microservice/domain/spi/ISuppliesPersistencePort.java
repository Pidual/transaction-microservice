package com.emazon.transaction_microservice.domain.spi;

import com.emazon.transaction_microservice.domain.model.Supply;

public interface ISuppliesPersistencePort {

    void saveSupplies(Supply supply);

    void getSupplies(Long id);




}
