package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;

public interface RequestValidator {

    UploadRequestValidationResult validateUploadRequest(RequestData requestData);
}
