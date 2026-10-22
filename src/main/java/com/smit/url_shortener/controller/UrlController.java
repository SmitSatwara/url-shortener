package com.smit.url_shortener.controller;

import com.smit.url_shortener.dto.CreateUrlRequest;
import com.smit.url_shortener.dto.UrlResponse;
import com.smit.url_shortener.service.UrlMappingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
public class UrlController {
    private final UrlMappingService urlMappingService;

    @PostMapping
    public ResponseEntity<UrlResponse>  createShortUrl(@Valid @RequestBody CreateUrlRequest request){
        UrlResponse response = urlMappingService.createShortUrl(request);
        return ResponseEntity.created(URI.create(response.getShortUrl())).body(response);
    }
}
