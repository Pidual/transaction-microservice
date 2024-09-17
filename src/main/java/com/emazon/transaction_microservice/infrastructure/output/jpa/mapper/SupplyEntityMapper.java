package com.emazon.transaction_microservice.infrastructure.output.jpa.mapper;

import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.infrastructure.output.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {

    SupplyEntity toEntity(Supply supply);

    Supply toSupply(SupplyEntity supplyEntity);

}
