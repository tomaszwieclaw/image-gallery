package org.baldogru.imagegallery.model.dto;

import lombok.*;
import org.baldogru.imagegallery.constants.ValidationStatus;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationResult {
    @NonNull
    private final ValidationStatus validationStatus;
}
