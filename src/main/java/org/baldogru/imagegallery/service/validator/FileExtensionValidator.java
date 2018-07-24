package org.baldogru.imagegallery.service.validator;

import org.apache.commons.io.FilenameUtils;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public final class FileExtensionValidator implements SpecializedValidator {

    FileExtensionValidator() {}

    @Value("'${image.allowed.extensions}'.split(',')")
    private List<String> allowedImageExtensions;

    @Override
    public ValidationResult validate(RequestData requestData) {
        //Polecam skorzystac z tego gowna z apache commons-> FilenameUtils.getExtension()
        return null;
    }
}
