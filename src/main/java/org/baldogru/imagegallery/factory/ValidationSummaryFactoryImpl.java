package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
class ValidationSummaryFactoryImpl implements ValidationSummaryFactory {

    ValidationSummaryFactoryImpl() {
    }

    @Override
    public ValidationSummary create(List<ValidationResult> validationResults) {
        List<ValidationResult> successValidationResults =
                validationResults.stream().filter(isValidationResultSuccess()).collect(Collectors.toList());
        ValidationStatus validationStatus = returnSuccessIfFailValidationResultsIsEmptyElseReturnFail(successValidationResults);
        return ValidationSummary.builder()
                .validationResults(validationResults)
                .validationStatus(validationStatus)
                .build();
    }


    private Predicate<ValidationResult> isValidationResultSuccess() {
        return validationResult -> validationResult.getValidationStatus().equals(ValidationStatus.SUCCESS);
    }


    private ValidationStatus returnSuccessIfFailValidationResultsIsEmptyElseReturnFail(List<ValidationResult> successValidationResults) {
        if (successValidationResults == null || successValidationResults.size() == 0) {
            return ValidationStatus.SUCCESS;
        }
        return ValidationStatus.FAIL;
    }
}
