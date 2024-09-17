package com.emazon.transaction_microservice.application.mapper;


import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyMapper {

    Supply toSupply(SupplyRequestDTO supplyRequestDTO);

    SupplyRequestDTO toSupplyRequestDTO(Supply supply);
}
