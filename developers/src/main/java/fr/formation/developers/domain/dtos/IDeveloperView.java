package fr.formation.developers.domain.dtos;

import java.time.LocalDate;

/**
 * Projection par interface pour les vues (outputs). On déclare les "getters"
 * des données qu'on souhaite récupérer de la base de données sur une entité.
 * Les types et les nommages doivent correspondre à ce qui est déclaré dans
 * l'entité.
 * <p>
 * Cette interface nous permet de ne projeter uniquement le pseudo et la date de
 * naissance d'un développeur. Permet d'écrire moins de code et d'optimiser la
 * requête SQL car Spring va uniquement projeter les colonnes concernées et non
 * pas toutes les colonnes de la table dans la clause SELECT.
 */
public interface IDeveloperView {

    String getPseudo();

    LocalDate getBirthDate();
}
