package com.smit.url_shortener.service;

import com.smit.url_shortener.dto.CreateUrlRequest;
import com.smit.url_shortener.dto.UrlResponse;
import com.smit.url_shortener.entity.UrlMapping;
import com.smit.url_shortener.repository.UrlMappingRepository;
import com.smit.url_shortener.util.Base62;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service@RequiredArgsConstructor
public class UrlMappingService {

    private final UrlMappingRepository urlMappingRepository;
    private static final String BASE_URL = "http://localhost:8080/";

    public UrlResponse createShortUrl(CreateUrlRequest request){
        long id  = urlMappingRepository.getNextId();
        String code = Base62.encode(id);
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setId(id);
        urlMapping.setOriginalUrl(request.getOriginalUrl());
        urlMapping.setShortCode(code);
        urlMapping.setExpiresAt(request.getExpiresAt());

        UrlMapping savedUrlMapping= urlMappingRepository.save(urlMapping);

        return new UrlResponse(savedUrlMapping.getShortCode(),BASE_URL +savedUrlMapping.getShortCode(),savedUrlMapping.getOriginalUrl(),savedUrlMapping.getExpiresAt());


    }

}
