package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.constants.ValidatorType;
import org.baldogru.imagegallery.service.validator.SpecializedValidator;

import java.util.List;

public interface SpecializedValidatorFactory {

    List<SpecializedValidator> createValidators(ValidatorType validatorType);

}
