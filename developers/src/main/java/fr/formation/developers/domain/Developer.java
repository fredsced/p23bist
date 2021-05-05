package fr.formation.developers.domain;

import java.time.LocalDate;

public class Developer {

    private String pseudo;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    public Developer() {
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

    @Override
    public String toString() {
	return "Developer [pseudo=" + pseudo + ", firstName=" + firstName
		+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
    }
}
