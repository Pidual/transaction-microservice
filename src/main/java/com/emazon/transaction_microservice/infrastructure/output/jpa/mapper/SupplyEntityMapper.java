package com.emazon.transaction_microservice.infrastructure.output.jpa.mapper;

import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.infrastructure.output.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SupplyEntityMapper {

    SupplyEntity toSuplyEntity(Supply supply);

    Supply toSuply(SupplyEntity supplyEntity);

}
