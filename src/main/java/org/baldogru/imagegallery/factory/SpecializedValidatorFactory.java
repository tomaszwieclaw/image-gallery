package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.constants.RequestType;
import org.baldogru.imagegallery.service.validator.SpecializedValidator;

import java.util.List;

public interface SpecializedValidatorFactory {

    List<SpecializedValidator> getValidators(RequestType requestType);

}
