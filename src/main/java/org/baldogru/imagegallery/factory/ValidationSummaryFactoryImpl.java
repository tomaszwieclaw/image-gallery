package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.baldogru.imagegallery.service.validator.ValidationStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
class ValidationSummaryFactoryImpl implements ValidationSummaryFactory {

    private final ValidationStatusService validationStatusService;

    public ValidationSummaryFactoryImpl(ValidationStatusService validationStatusService) {
        this.validationStatusService = validationStatusService;
    }

    @Override
    public ValidationSummary create(List<ValidationResult> validationResults) {
        ValidationStatus validationStatus = validationStatusService.validate(validationResults);
        return ValidationSummary.builder()
                .validationResults(validationResults)
                .validationStatus(validationStatus)
                .build();
    }
    
}
