package org.baldogru.imagegallery.service;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;
import org.baldogru.imagegallery.service.validator.RequestValidator;
import org.baldogru.imagegallery.service.wrapper.RequestWrappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public final class ImageServiceImpl implements ImageService {

    private final RequestWrappingService requestWrappingService;
    private final RequestValidator requestValidator;

    ImageServiceImpl(RequestWrappingService requestWrappingService,
                     RequestValidator requestValidator) {
        this.requestWrappingService = requestWrappingService;
        this.requestValidator = requestValidator;
    }

    @Override
    public ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData) {
        RequestData requestData = requestWrappingService.wrapUploadData(image, uploadData);
        UploadRequestValidationResult validationResult = requestValidator.validateUploadRequest(requestData);
        //CZEMU NOT_FOUND jest zwracany ? :P
        return new ResponseEntity<ImageUploadResult>(new ImageUploadResult(), HttpStatus.NOT_FOUND);
    }
}
