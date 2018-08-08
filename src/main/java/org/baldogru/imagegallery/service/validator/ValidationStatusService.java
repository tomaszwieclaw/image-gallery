package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.model.dto.ValidationResult;

import java.util.List;

public interface ValidationStatusService {
    ValidationStatus validate(List<ValidationResult> validationResults);
}
