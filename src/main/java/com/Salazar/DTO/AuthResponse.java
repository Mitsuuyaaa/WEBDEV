package com.Salazar.DTO;

public record AuthResponse(String token, String username, Long expiresAt) {
}