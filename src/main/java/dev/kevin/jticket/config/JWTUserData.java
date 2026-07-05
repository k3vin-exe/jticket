package dev.kevin.jticket.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
