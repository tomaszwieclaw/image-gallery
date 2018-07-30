package org.baldogru.imagegallery.model.dto;

import lombok.*;
import org.baldogru.imagegallery.constants.ValidationStatus;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationSummary {
    @NonNull
    private final ValidationStatus validationStatus;
    @NonNull
    private List<ValidationResult> validationResults;
}
