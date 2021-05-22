package fr.formation.developers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.developers.domain.entities.Skill;

/**
 * Caractéristique de "Spring data" qui aide les développeurs à interagir avec
 * la base de données sur un type d'entité spécifique (ici "Skill"), permet
 * d'écrire beaucoup moins de code pour les opérations classiques (CRUD).
 * Conventions de nommage comme pour le controller et le service.
 * <p>
 * Le principe est de déclarer une interface pour chaque type d'entité qui étend
 * l'interface du framework "JpaRepository", on précise les types paramétrés de
 * l'interface avec "Skill" pour l'entité et "Long" pour le type du champ "id"
 * correspondant à la clef primaire.
 * <p>
 * En étendant l'interface de Spring on bénéficie d'un ensemble de méthodes déjà
 * déclarées (et implémentées par Spring) pour les opérations fréquentes (save,
 * delete, find...) mais on peut également déclarer nos propres méthodes, comme
 * ici avec "findByName". C'est ce qu'on appelle une "query method" ou "derived
 * query".
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {

    /**
     * Requête dérivée interprétée par Spring grâce à une convention de
     * dnommage. Le préfixe "findBy" correspondant à une requêtes SELECT, on n'a
     * pas à préciser l'entité car elle est déjà déclarée en type parémétré de
     * l'interface "JpaRepository", puis "Name" pour la clause WHERE. "Name" est
     * le champ "name" de la classe "Skill" passé en camelCase.
     * <p>
     * Avec le respect de ces conventions, Spring (en s'appuyant sur
     * JPA/Hibernate) peut écrire la requête SQL suivante à envoyer à la base de
     * données: "SELECT * FROM skills where name = ?". Le "?" est un paramètre
     * remplacé par la valeur (le "name" passé à l'appel de la méthode).
     * <p>
     * Le framework s'occupe d'instancier la classe et de setter les valeurs à
     * partir du résultat de la requête.
     *
     * @param name le nom de compétence à rechercher
     * @return un "Optional" encapsulant l'objet "Skill" trouvé ou "null" si pas
     *         de compétence avec ce nom
     */
    Optional<Skill> findByName(String name);
}
