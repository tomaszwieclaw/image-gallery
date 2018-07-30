package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.RequestType;
import org.baldogru.imagegallery.service.validator.SpecializedValidator;

public interface ValidatorsConfiguration {

    boolean isValidatorActive(RequestType requestType, Class<? extends SpecializedValidator> validatorClass);

}
