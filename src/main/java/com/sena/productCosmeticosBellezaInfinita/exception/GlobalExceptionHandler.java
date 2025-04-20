package com.sena.productCosmeticosBellezaInfinita.exception;

import com.sena.productCosmeticosBellezaInfinita.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleUnhandledExceptions(Exception ex) {
        System.err.println("Excepción no controlada: " + ex);
        return ResponseEntity.ok(new ApiResponse(
                true,
                "Ha ocurrido un error inesperado. Por favor contacta al administrador.",
                null
                ));
    }
}
