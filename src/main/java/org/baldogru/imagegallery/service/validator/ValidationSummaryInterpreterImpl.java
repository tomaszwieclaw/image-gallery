package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.exception.FailValidationException;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.springframework.stereotype.Service;

@Service
class ValidationSummaryInterpreterImpl implements ValidationSummaryInterpreter {

    ValidationSummaryInterpreterImpl() {}

    @Override
    public void processValidationSummary(ValidationSummary validationSummary) {
        throwExceptionIfValidationSummaryIsFailed(validationSummary);
    }

    private void throwExceptionIfValidationSummaryIsFailed(ValidationSummary validationSummary) {
        if (validationSummary.getValidationStatus().equals(ValidationStatus.FAIL)) {
            throw new FailValidationException();
        }
    }
}
