package com.auth.service.auth_service.dto;


import java.util.Map;

public record ErrorResponseDTO(String message, Map<String, String> details) {

    public ErrorResponseDTO(String message) {
        this(message, null);
    }
}
