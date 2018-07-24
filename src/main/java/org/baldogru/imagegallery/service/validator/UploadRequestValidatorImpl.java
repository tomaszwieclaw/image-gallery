package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.ValidatorType;
import org.baldogru.imagegallery.factory.SpecializedValidatorFactory;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.UploadRequestValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .map(specializedValidator -> specializedValidator.validate(requestData))
                .collect(Collectors.toList());
        //z tego wy¿ej ma powstaæ UploadRequestValidationResult - licze na twórczoœæ w³asn¹.
        //Je¿eli masz inny pomys³ to œmia³o commituj, bêdziemy dyskutowaæ
        return null;
    }
}
