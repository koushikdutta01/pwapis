package com.pwapi.pwapi.controller;

import com.pwapi.pwapi.entity.ImageData;
import com.pwapi.pwapi.service.ImageDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageDataController {

    private final ImageDataService imageDataService;

    public ImageDataController(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadImage(
            @RequestParam("title") String title,
            @RequestParam("about") String about,
            @RequestParam("image") MultipartFile file) {
        try {
            imageDataService.saveImageData(title, about, file);
            return ResponseEntity.status(HttpStatus.CREATED).body("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageData> getImageData(@PathVariable Long id) {
        return imageDataService.getImageData(id)
                .map(imageData -> ResponseEntity.ok().body(imageData))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
