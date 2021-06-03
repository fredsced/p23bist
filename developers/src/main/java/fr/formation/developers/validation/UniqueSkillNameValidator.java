package fr.formation.developers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.developers.repositories.SkillRepository;

public class UniqueSkillNameValidator
	implements ConstraintValidator<UniqueSkillName, String> {

    private final SkillRepository skills;

    public UniqueSkillNameValidator(SkillRepository skills) {
	this.skills = skills;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null) {
	    return true;
	}
	// Existe-t-il un objet Skill dont le nom = value
	// select * from skills where name = 'JAVA' => true => false
	// si JAVA existe alors c'est pas valide
	// select * from skills where name = 'JAVASCRIPT' => false => true
	// si JAVASCRIPT n'existe pas alors c'est valide
	return !skills.existsByName(value); // inverse existsByName
    }
}
