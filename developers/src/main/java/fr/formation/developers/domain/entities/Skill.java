package fr.formation.developers.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Une classe dite "entité", un objet métier, un objet du domaine fonctionnel de
 * l'application. On retrouve ces entités côté base de données sous la forme de
 * tables.
 */
// Indique au framework que cette classe est une entité
@Entity
// Indique au framework le nom de la table correspondante
// si pas précisé, le nom par défaut considéré serait
// le nom de la classe en minuscules. Permet de respecter des
// Conventions de nommage spécifiques à la base de données.
@Table(name = "skills")
public class Skill {

    // On indique ici que le champ est celui associé à la clef primare de la
    // table.
    // Le nom "id" est conventionnel, "@Id" est obligatoire pour le mpaiing de
    // chaque entité/table.
    @Id
    // On précise comment sont gérées les clefs primaires, la stratégie
    // "IDENTITY"
    // indique au framework que la bdd gère la génération de la valeur de la
    // clef
    // (par exemple auto increment avec MySQL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // On précise le nom de la colonne correspondante au champ
    @Column(name = "skill_name", nullable = false, unique = true)
    private String name;

    public Skill() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Skill [id=" + id + ", name=" + name + "]";
    }
}
