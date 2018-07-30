package org.baldogru.imagegallery.service.validator;

import org.baldogru.imagegallery.model.dto.ValidationSummary;
import org.springframework.stereotype.Service;

@Service
class ValidationSummaryInterpreterImpl implements ValidationSummaryInterpreter {

    ValidationSummaryInterpreterImpl() {}

    @Override
    public void processValidationSummary(ValidationSummary validationSummary) {
        //Możesz sprobowac cos zaimplementowac.
        //Chodzi np. o to, ze jak wynik walidacji bedzie chujowy,
        //to zeby to np rzuciło na razie wyjatkiem,
        //a jak bedzie ok to zeby po prostu nie robilo nic.
        //Potem wymyslimy jak tu zaimplementować fajną obsługę co zwróci ładny komunikat z listą błędów.
        //Chyba, że masz pomysł, to możesz coś zasugerować, ale wtedy raczej tutaj nie będzie zwracany void :)
    }
}
