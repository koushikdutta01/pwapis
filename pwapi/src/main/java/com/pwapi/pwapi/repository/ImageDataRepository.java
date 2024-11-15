package com.pwapi.pwapi.repository;


import com.pwapi.pwapi.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByTitle(String title);
}