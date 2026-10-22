package com.smit.url_shortener.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "url_mapping")
@Getter
@Setter
public class UrlMapping {
    @Id
    private Long id;

    @Column(nullable = false,unique = true,length = 10)
    private String shortCode;
    @Column(nullable = false,length = 2048)
    private String originalUrl;
    @Column(nullable = false)
    private Instant createdAt;
    private Instant expiresAt;
    private long clickCount=0;


    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }


}
