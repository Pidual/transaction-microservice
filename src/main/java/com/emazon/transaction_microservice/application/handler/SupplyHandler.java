package com.emazon.transaction_microservice.application.handler;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.application.mapper.SupplyMapper;
import com.emazon.transaction_microservice.domain.api.ISupplyServicePort;

import com.emazon.transaction_microservice.domain.model.Supply;
import com.emazon.transaction_microservice.infrastructure.output.feign.IStockFeignClient;
import com.emazon.transaction_microservice.infrastructure.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyHandler implements ISuppliesHandler {

    private final ISupplyServicePort supplyUseCase;
    private final IStockFeignClient stockServiceFeignClient;
    private final SupplyMapper supplyMapper;


    @Override
    public void addSupplies(SupplyRequestDTO supplyDTO) {
        // Extract token from HTTP request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("JWT token is missing or invalid");
        }
        // Strip the "Bearer " prefix to get the raw token
        token = token.substring(7);
        // Extract authentication for user information (optional)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication != null ? authentication.getPrincipal().toString() : "unknown-user";
        // Map the SupplyRequestDTO to the domain model
        Supply supply = supplyMapper.toSupply(supplyDTO);
        supply.setUserEmail(email);
        // Call Feign client with the token
        supplyUseCase.addSuppliesToArticle(supply);
        stockServiceFeignClient.updateArticleQuantity("Bearer " + token, supplyDTO);

    }





}
