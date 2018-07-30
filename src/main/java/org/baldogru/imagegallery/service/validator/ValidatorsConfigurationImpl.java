package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.RequestType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
final class ValidatorsConfigurationImpl implements ValidatorsConfiguration {

    private static final Map<RequestType, List<Class<? extends SpecializedValidator>>> CONFIGURATION;

    static {
        CONFIGURATION = new EnumMap<>(RequestType.class);

        CONFIGURATION.put(
                RequestType.UPLOAD_IMAGE,
                Arrays.asList(
                        FileExtensionValidator.class,
                        FileNameValidator.class,
                        FileSizeValidator.class
                ));
    }

    @Override
    public boolean isValidatorActive(RequestType requestType, Class<? extends SpecializedValidator> validatorClass) {
        Objects.requireNonNull(validatorClass);
        return Optional.ofNullable(CONFIGURATION.get(requestType))
                .orElse(Collections.emptyList())
                .stream()
                .anyMatch(configurationClass -> configurationClass.equals(validatorClass));
    }
}
