package fr.formation.developers.domain.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Un DTO représentant tous les inputs du client, généralement pour un endpoint
 * donné, on y précise les contraintes de validation par champ et/ou par classe
 * dans le cas d'une validation nécessitant d'accéder à plusieurs champs.
 */
public class DeveloperCreate {

    @NotBlank
    private String pseudo;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Long mainSkillId;

    public DeveloperCreate() {
	//
    }

    public String getPseudo() {
	return pseudo;
    }

    public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public Long getMainSkillId() {
	return mainSkillId;
    }

    public void setMainSkillId(Long mainSkillId) {
	this.mainSkillId = mainSkillId;
    }

    @Override
    public String toString() {
	return "Developer [pseudo=" + pseudo + ", firstName=" + firstName
		+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
    }
}
