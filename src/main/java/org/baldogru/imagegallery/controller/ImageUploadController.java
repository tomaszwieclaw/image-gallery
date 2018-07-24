package org.baldogru.imagegallery.controller;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadController {

    /**
     *  Metoda pozwala na przes�anie pliku b�d�cego obrazem.
     *  Przes�any plik jest walidowany.
     *
     * @param image plik obrazu
     * @param uploadData metadane przesy�anego pliku
     * @return wynik operacji
     */
    ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData);

}
