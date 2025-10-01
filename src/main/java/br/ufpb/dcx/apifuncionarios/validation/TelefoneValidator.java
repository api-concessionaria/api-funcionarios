package br.ufpb.dcx.apifuncionarios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isBlank()) {
            return false;
        }

        String telefone = s.replaceAll("//D", "");

        if (!telefone.matches("//d{11}")) {
            return false;
        }

        return telefone.charAt(2) == '9';
    }
}
