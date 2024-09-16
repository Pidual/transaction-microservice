package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyDTORequest;

public interface ISuppliesHandler {


    //hu.9  agregar suministro los suministros nuevos tienen que incrementar la cantidd de suministros existentes
    void addSupplies(SupplyDTORequest user);


}
