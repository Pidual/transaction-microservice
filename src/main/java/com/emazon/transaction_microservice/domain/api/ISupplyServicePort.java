package com.emazon.transaction_microservice.domain.api;

import com.emazon.transaction_microservice.domain.model.Supply;

import java.util.List;

public interface ISupplyServicePort {

    void addSuppliesToArticle(Supply supply);

    List<Supply> getSupplies();

}
