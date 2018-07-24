package org.baldogru.imagegallery.controller;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadController {

    /**
     *  Metoda pozwala na przesłanie pliku będącego obrazem.
     *  Przesłany plik jest walidowany.
     *
     * @param image plik obrazu
     * @param uploadData metadane przesyłanego pliku
     * @return wynik operacji
     */
    ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData);

}
