package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationSummary;

public interface RequestValidator {

    ValidationSummary validateRequest(RequestData requestData);
}
