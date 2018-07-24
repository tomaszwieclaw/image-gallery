package org.baldogru.imagegallery.service;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData);

}
