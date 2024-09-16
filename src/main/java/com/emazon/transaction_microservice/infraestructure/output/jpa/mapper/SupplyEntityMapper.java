package com.emazon.transaction_microservice.infraestructure.output.jpa.mapper;

import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.infraestructure.output.jpa.entity.SupplyEntity;

@Mapper
public interface SupplyEntityMapper {

    SupplyEntity toSuplyEntity(Supply supply);

    Supply toSuply(SupplyEntity supplyEntity);

}
