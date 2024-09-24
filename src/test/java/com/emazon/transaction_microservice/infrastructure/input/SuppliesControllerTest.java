package com.emazon.transaction_microservice.infrastructure.input;

import com.emazon.transaction_microservice.application.dto.SupplyRequestDTO;
import com.emazon.transaction_microservice.application.handler.ISuppliesHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SuppliesControllerTest {

    @Mock
    private ISuppliesHandler suppliesHandler;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private SuppliesController suppliesController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSupply_Success() {
        // Arrange
        SupplyRequestDTO supplyRequestDTO = new SupplyRequestDTO("Laptop", 10);
        String token = "Bearer sample-jwt-token";
        String email = "user@example.com";

        // Simular la cabecera de autorización
        when(httpServletRequest.getHeader("Authorization")).thenReturn(token);

        // Simular el contexto de seguridad
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(email);
        SecurityContextHolder.setContext(securityContext);

        // Act
        ResponseEntity<Void> response = suppliesController.addSupply(supplyRequestDTO, httpServletRequest);

        // Assert
        verify(suppliesHandler, times(1)).addSupplies(supplyRequestDTO, token, email);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testAddSupply_WithoutAuthorizationHeader() {
        // Arrange
        SupplyRequestDTO supplyRequestDTO = new SupplyRequestDTO("Laptop", 10);
        String email = "user@example.com";

        // Simular que no se envía el token
        when(httpServletRequest.getHeader("Authorization")).thenReturn(null);

        // Simular el contexto de seguridad
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(email);
        SecurityContextHolder.setContext(securityContext);

        // Act
        ResponseEntity<Void> response = suppliesController.addSupply(supplyRequestDTO, httpServletRequest);

        // Assert
        verify(suppliesHandler, times(1)).addSupplies(supplyRequestDTO, null, email);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testAddSupply_WithoutAuthentication() {
        // Arrange
        SupplyRequestDTO supplyRequestDTO = new SupplyRequestDTO("Laptop", 10);
        String token = "Bearer sample-jwt-token";

        // Simular la cabecera de autorización
        when(httpServletRequest.getHeader("Authorization")).thenReturn(token);

        // Simular que no hay autenticación en el contexto
        when(securityContext.getAuthentication()).thenReturn(null);
        SecurityContextHolder.setContext(securityContext);

        // Act
        ResponseEntity<Void> response = suppliesController.addSupply(supplyRequestDTO, httpServletRequest);

        // Assert
        verify(suppliesHandler, times(1)).addSupplies(supplyRequestDTO, token, "unknown-user");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}