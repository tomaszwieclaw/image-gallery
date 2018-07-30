package org.baldogru.imagegallery.controller;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public interface ImageUploadController {

    /**
     *  Metoda pozwala na przesłanie pliku będącego obrazem.
     *  Przesłany plik jest walidowany.
     *
     * @param image plik obrazu
     * @param uploadData metadane przesyłanego pliku
     * @return wynik operacji
     */
    @PostMapping("")
    ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData);

}
