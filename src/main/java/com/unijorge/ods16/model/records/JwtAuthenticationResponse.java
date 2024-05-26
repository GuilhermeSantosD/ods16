package com.unijorge.ods16.model.records;

public record JwtAuthenticationResponse(
        String accessToken,
        String tokenType) {
}
