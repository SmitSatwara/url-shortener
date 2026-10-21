package com.smit.url_shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter@AllArgsConstructor
public class UrlResponse {
    private String shortCode;
    private String shortUrl;
    private String originalUrl;
    private Instant expiresAt;
}
