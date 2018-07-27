package org.baldogru.imagegallery.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UploadRequestValidationResult {

    private List<ValidationResult> successValidationResult = new ArrayList<>();
    private List<ValidationResult> failedValidationResult = new ArrayList<>();
}
