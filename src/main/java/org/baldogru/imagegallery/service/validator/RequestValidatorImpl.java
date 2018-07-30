package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.factory.SpecializedValidatorFactory;
import org.baldogru.imagegallery.factory.ValidationSummaryFactory;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
final class RequestValidatorImpl implements RequestValidator {

    private final SpecializedValidatorFactory specializedValidatorFactory;
    private final ValidationSummaryFactory validationSummaryFactory;

    RequestValidatorImpl(SpecializedValidatorFactory specializedValidatorFactory, ValidationSummaryFactory validationSummaryFactory) {
        this.specializedValidatorFactory = specializedValidatorFactory;
        this.validationSummaryFactory = validationSummaryFactory;
    }

    @Override
    public ValidationSummary validateRequest(RequestData requestData) {
        Objects.requireNonNull(requestData);
        List<ValidationResult> validationResults = specializedValidatorFactory
                .getValidators(requestData.getRequestType())
                .stream()
                .map(specializedValidator -> specializedValidator.validate(requestData))
                .collect(Collectors.toList());
        return validationSummaryFactory.create(validationResults);
    }
}
