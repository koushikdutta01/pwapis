package com.pwapi.pwapi.service;
import com.pwapi.pwapi.entity.ImageData;
import com.pwapi.pwapi.repository.ImageDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {
    private final ImageDataRepository imageDataRepository;

    public ImageDataService(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    public ImageData saveImageData(String title, String about, MultipartFile file) throws IOException {
        ImageData imageData = new ImageData();
        imageData.setTitle(title);
        imageData.setAbout(about);
        imageData.setImage(file.getBytes());
        return imageDataRepository.save(imageData);
    }

    public Optional<ImageData> getImageData(Long id) {
        return imageDataRepository.findById(id);
    }
}
