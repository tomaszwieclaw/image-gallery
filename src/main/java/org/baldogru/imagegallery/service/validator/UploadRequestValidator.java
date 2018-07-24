package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;

public interface UploadRequestValidator {
    UploadRequestValidationResult validateUploadRequest(RequestData requestData);
}
