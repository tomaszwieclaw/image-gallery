package org.baldogru.imagegallery.controller;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.baldogru.imagegallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


class ImageUploadControllerImpl implements ImageUploadController {

    private final ImageService imageService;

    @Autowired
    public ImageUploadControllerImpl(ImageService imageService) {
        this.imageService = imageService;
    }


    @Override
    public ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData) {
        return imageService.uploadImage(image, uploadData);
    }
}
