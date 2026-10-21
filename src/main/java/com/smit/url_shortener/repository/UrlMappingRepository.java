package com.smit.url_shortener.repository;

import com.smit.url_shortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {
    Optional<UrlMapping> findByShortCode(String code);

    @Query(nativeQuery = true,value = "SELECT nextval('url_mapping_id_seq')")
    long getNextId();
}
