package com.smit.url_shortener.dto;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter@Setter
public class CreateUrlRequest {
    @NotBlank @Size(max=2048) @Pattern(regexp = "https?://.+", message = "URL must start with http:// or https://")
    private String originalUrl;
    @Future
    private Instant expiresAt;

}
