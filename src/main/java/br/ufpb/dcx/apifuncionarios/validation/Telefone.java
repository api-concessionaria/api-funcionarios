package br.ufpb.dcx.apifuncionarios.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelefoneValidator.class)
@Documented
public @interface Telefone {
    String message() default "Telefone inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
