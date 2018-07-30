package org.baldogru.imagegallery.factory;

import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.baldogru.imagegallery.model.dto.ValidationSummary;

import java.util.List;

public interface ValidationSummaryFactory {
    ValidationSummary create(List<ValidationResult> validationResults);
}
