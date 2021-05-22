package fr.formation.developers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Classe implémentant la règle de validation correspondant à l'annotation.
 * <p>
 * Il faut implémenter l'interface "ConstraintValidator" en spécifiant les
 * paramètres "Uppercase" qui est le type de l'annotation et "String" le type du
 * champ validé. On retrouve le même type de champ validé en premier argument de
 * la méthode "isValid".
 */
public class UppercaseValidator
	implements ConstraintValidator<Uppercase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	// Value doit être en majuscule
	// Si value n'est pas en majuscules alors return false
	// Si value est en majuscules alors return false
	// Comparer value à sa version en majuscules (forcer)
	if (value == null) {
	    return true;
	}
	String uppercased = value.toUpperCase();
	return value.equals(uppercased);
	// return value == uppercased; VERY BAD
    }
}
