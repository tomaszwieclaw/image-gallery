package org.baldogru.imagegallery.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.baldogru.imagegallery.constants.ValidationResultType;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationResult {
    private final ValidationResultType validationResultType;
}
