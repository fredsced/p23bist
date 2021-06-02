package fr.formation.developers.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudonyme", unique = true, nullable = false)
    private String pseudo;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    // 1 Developer maitrise 1 Skill
    // 1 Skill est maitrisee par N Developer
    //
    // 1 Developer ToOne Skill
    // Many Developers to One Skill
    // 1 Skill ToMany Developer
    // One Skill toMany Developers
    // @Many(Developers)ToOne(Skill)
    @ManyToOne
    @JoinColumn(name = "main_skill_id", nullable = false)
    private Skill mainSkill;

    public Developer() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public Skill getMainSkill() {
	return mainSkill;
    }

    public void setMainSkill(Skill mainSkill) {
	this.mainSkill = mainSkill;
    }
}
