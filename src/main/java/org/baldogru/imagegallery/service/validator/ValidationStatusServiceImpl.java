package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.constants.ValidationStatus;
import org.baldogru.imagegallery.model.dto.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
final class ValidationStatusServiceImpl implements ValidationStatusService {

    public ValidationStatusServiceImpl() {
    }

    @Override
    public ValidationStatus validate(List<ValidationResult> validationResults) {
        //Tutaj też musze sprwadzić czy validationResults nie jest nullem, ale co zrobić w przypadku jeśli będzie ?
        //Przydał by się może jakiś nowy ValidationStatus np. BAD_REQUEST ?
        List<ValidationResult> successValidationResults =
                validationResults.stream()
                        .filter(isValidationResultSuccess())
                        .collect(Collectors.toList());
        return returnFailIfSuccessValidationResultsIsEmptyElseReturnSuccess(successValidationResults);
    }


    private Predicate<ValidationResult> isValidationResultSuccess() {
        return validationResult -> validationResult.getValidationStatus().equals(ValidationStatus.SUCCESS);
    }


    private ValidationStatus returnFailIfSuccessValidationResultsIsEmptyElseReturnSuccess(List<ValidationResult> successValidationResults) {
        if (successValidationResults == null || successValidationResults.size() == 0) {
            return ValidationStatus.FAIL;
        }
        return ValidationStatus.SUCCESS;
    }
}
