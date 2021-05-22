package fr.formation.developers.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// Annotation traitée à l'exécution
@Retention(RUNTIME)
// Annotation qui a comme cible un champ de classe
@Target(FIELD)
// Validateur correspondant
@Constraint(validatedBy = { UppercaseValidator.class })
public @interface Uppercase {

    // Message par défaut en cas d'erreur
    String message() default "Doit être en majuscules";

    // Permet de regrouper et séquencer des contraintes
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
