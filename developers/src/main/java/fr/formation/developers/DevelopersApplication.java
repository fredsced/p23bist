package fr.formation.developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application, expose la méthode "main" qui est le point
 * d'entrée de tout programme Java.
 * <p>
 * Elle est dans le package racine, ici "fr.formation.developers" et tout le
 * code de l'application Spring boot doit se trouver dans cette hiérarchie.
 * Ainsi, quand on a besoin de nouveaux packages, ces derniers doivent être
 * ajoutés en sous-packages à "fr.formation.developers", par exemple :
 * <ul>
 * <li>"fr.formation.developers.controllers"
 * <li>"fr.formation.developers.domain"
 * </ul>
 * Ceci car une application Spring boot scanne tous les packages qui se situent
 * dans cette hiérarchie de packages (incluant le package racine) et ignore les
 * autres, comme par exemple "fr.formation.controllers".
 * <p>
 * Au démarrage de l'application, Spring boot scanne donc tous les packages et
 * part à la recherche de classes annotées avec des annotations Spring, à
 * commencer par cette classe-ci "DevelopersApplication" qui est annotée
 * "@SpringBootApplication". Chaque classe annotée avec une annotation Spring
 * sera considérée par le framework qui appliquera les traitements
 * correspondants à l'annotation.
 */
@SpringBootApplication
public class DevelopersApplication {

    public static void main(String[] args) {
	// Le code ci-dessous est exécuté quand la méthode main est appelée au
	// démarrage de l'application Java, c'est à partir de là que ça devient
	// une application Spring boot.
	SpringApplication.run(DevelopersApplication.class, args);
    }
}
