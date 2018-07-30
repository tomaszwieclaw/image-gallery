package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.stereotype.Service;

@Service
final class FileSizeValidator implements SpecializedValidator {

    FileSizeValidator () {}

    @Override
    public ValidationResult validate(RequestData requestData) {
        return null;
    }
}
