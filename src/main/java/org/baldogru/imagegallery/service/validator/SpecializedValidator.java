package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationResult;

public interface SpecializedValidator {

    ValidationResult validate(RequestData requestData);

}
