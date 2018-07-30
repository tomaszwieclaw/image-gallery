package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.service.validator.ValidatorsConfiguration;
import org.baldogru.imagegallery.constants.RequestType;
import org.baldogru.imagegallery.service.validator.SpecializedValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
final class SpecializedValidatorFactoryImpl implements SpecializedValidatorFactory {

    private final List<SpecializedValidator> specializedValidators;
    private final ValidatorsConfiguration validatorsConfiguration;

    SpecializedValidatorFactoryImpl(List<SpecializedValidator> specializedValidators,
                                    ValidatorsConfiguration validatorsConfiguration) {
        this.specializedValidators = specializedValidators;
        this.validatorsConfiguration = validatorsConfiguration;
    }

    @Override
    public List<SpecializedValidator> getValidators(RequestType requestType) {
        return specializedValidators
                .stream()
                .filter(validator -> validatorsConfiguration.isValidatorActive(requestType, validator.getClass()))
                .collect(Collectors.toList());
    }
}
