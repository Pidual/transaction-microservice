package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyDTORequest;
import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * So what does the handler do?
 *
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISuppliesHandler {

    //useCases
    private final ISupplyServicePort supplyService;



    @Override
    public void addSupplies(SupplyDTORequest user) {

    }

    //WEAS >>???


}
