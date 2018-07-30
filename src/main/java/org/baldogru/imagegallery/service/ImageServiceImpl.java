package org.baldogru.imagegallery.service;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.ImageUploadResult;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.baldogru.imagegallery.service.validator.RequestValidator;
import org.baldogru.imagegallery.service.validator.ValidationSummaryInterpreter;
import org.baldogru.imagegallery.service.wrapper.RequestWrappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
final class ImageServiceImpl implements ImageService {

    private final RequestWrappingService requestWrappingService;
    private final RequestValidator requestValidator;
    private final ValidationSummaryInterpreter validationSummaryInterpreter;

    ImageServiceImpl(RequestWrappingService requestWrappingService,
                     RequestValidator requestValidator,
                     ValidationSummaryInterpreter validationSummaryInterpreter) {
        this.requestWrappingService = requestWrappingService;
        this.requestValidator = requestValidator;
        this.validationSummaryInterpreter = validationSummaryInterpreter;
    }

    @Override
    public ResponseEntity<ImageUploadResult> uploadImage(MultipartFile image, ImageUploadData uploadData) {
        RequestData requestData = requestWrappingService.wrapUploadData(image, uploadData);
        ValidationSummary validationSummary = requestValidator.validateRequest(requestData);
        validationSummaryInterpreter.processValidationSummary(validationSummary);
        //CZEMU NOT_FOUND jest zwracany ? :P - bo implementacja nie jest skończona i chciałem żeby się oczy rzucało i paliło
        return new ResponseEntity<>(ImageUploadResult.builder().build(), HttpStatus.NOT_FOUND);
    }
}
