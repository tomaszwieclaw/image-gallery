package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;
import org.springframework.stereotype.Service;

@Service
public final class RequestValidatorImpl implements RequestValidator {

    private final UploadRequestValidator uploadRequestValidator;

    RequestValidatorImpl(UploadRequestValidator uploadRequestValidator) {
        this.uploadRequestValidator = uploadRequestValidator;
    }

    @Override
    public UploadRequestValidationResult validateUploadRequest(RequestData requestData) {
        return uploadRequestValidator.validateUploadRequest(requestData);
    }
}
