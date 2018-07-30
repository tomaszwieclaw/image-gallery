package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ValidationSummaryFactoryImpl implements ValidationSummaryFactory {

    ValidationSummaryFactoryImpl() {}

    @Override
    public ValidationSummary create(List<ValidationResult> validationResults) {
        //Smialo dawaj jakas swoja implementacje tworzenia tego ValidationSummary
        return null;
    }
}
