package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.ValidationResultType;
import org.baldogru.imagegallery.constants.ValidatorType;
import org.baldogru.imagegallery.factory.SpecializedValidatorFactory;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public final class UploadRequestValidatorImpl implements UploadRequestValidator {

    private final SpecializedValidatorFactory specializedValidatorFactory;

    UploadRequestValidatorImpl(SpecializedValidatorFactory specializedValidatorFactory) {
        this.specializedValidatorFactory = specializedValidatorFactory;
    }

    @Override
    public UploadRequestValidationResult validateUploadRequest(final RequestData requestData) {
        List<ValidationResult> validationResults = specializedValidatorFactory
                .createValidators(ValidatorType.UPLOAD_VALIDATOR)
                .stream()
                .map(specializedValidator -> specializedValidator.validate(requestData))// zakladam ze validate, bedzie ustawiac FAIL/SUCCESS na ValidationResult?
                .collect(Collectors.toList());
        List<ValidationResult> successValidationResult = validationResults
                .stream()
                .filter(isValidationResultSuccessfull())
                .collect(Collectors.toList());
        List<ValidationResult> failedValidationResult = validationResults
                .stream()
                .filter(isValidationResultFailed())
                .collect(Collectors.toList());
        return UploadRequestValidationResult
                .builder()
                .successValidationResult(successValidationResult)
                .failedValidationResult(failedValidationResult)
                .build();
    }


    private Predicate<ValidationResult> isValidationResultSuccessfull() {
        return validationResult -> validationResult.getValidationResultType().equals(ValidationResultType.SUCCESS);
    }

    private Predicate<ValidationResult> isValidationResultFailed() {
        return validationResult -> validationResult.getValidationResultType().equals(ValidationResultType.FAIL);
    }
}
