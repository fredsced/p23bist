package fr.formation.developers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.developers.domain.dtos.IDeveloperView;
import fr.formation.developers.domain.entities.Developer;

@Repository // Option
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByPseudo(String pseudo);

    /**
     * Recherche un développeur par son prénom et son nom, exemple de requête
     * dérivée (ou query methods) qui combine les critères avec l'opérateur
     * "And".
     * <p>
     * En déclarant simplement le type de retour "IDeveloperView" qui est une
     * interface et non une classe concrète, Spring va projeter le résultat de
     * la requête dans une classe qui implémente cette interface (code généré
     * par Spring). Ce qui évite de récupérer toutes les propriétés d'un
     * développeur alors qu'on a besoin uniquement du pseudo et de la date de
     * naissance.
     */
    Optional<IDeveloperView> findByFirstNameAndLastName(String firstName,
	    String lastName);
}
