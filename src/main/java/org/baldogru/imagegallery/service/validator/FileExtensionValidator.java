package org.baldogru.imagegallery.service.validator;

import org.apache.commons.io.FilenameUtils;
import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
final class FileExtensionValidator implements SpecializedValidator {

    FileExtensionValidator() {
    }

    @Value("'${image.allowed.extensions}'.split(',')")
    private List<String> allowedImageExtensions;

    @Override
    public ValidationResult validate(RequestData requestData) {
        String fileName = requestData.getImageFile().getName();
        String fileExtension = FilenameUtils.getExtension(fileName);
        Optional<String> validatedFile = allowedImageExtensions.stream().filter(allowedExtension -> allowedExtension.equals(fileExtension)).findFirst();
        if (validatedFile.isPresent()) {
            return ValidationResult.builder()
                    .validationStatus(ValidationStatus.SUCCESS)
                    .build();
        }
        return ValidationResult
                .builder()
                .validationStatus(ValidationStatus.FAIL)
                .build();
    }
}
