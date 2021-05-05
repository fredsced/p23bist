package fr.formation.developers.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.developers.domain.Developer;

@RestController
/*
 * @RequestMapping permet d'indiquer le segment de la collection de ressources
 * une seule fois pour la classe au lieu de le répéter à chaque mapping. Spring,
 * au démarrage, concatène le nom de la collection avec tous les mappings
 * déclarés dans le controller. Ex. : "/developers" + "/{pseudo}" =>
 * "/developers/{pseudo}"
 */
@RequestMapping("/developers")
public class DeveloperController {

    @GetMapping("/{pseudo}")
    public Developer getByPseudo(@PathVariable("pseudo") String pseudo) {
	Developer developer = new Developer();
	developer.setPseudo(pseudo);
	developer.setFirstName("Frank");
	developer.setLastName("MARSHALL");
	LocalDate date = LocalDate.of(1974, 12, 26);
	developer.setBirthDate(date);
	return developer;
    }

    // Parenthèses optionnelles si pas de paramètres à une annotation
    @PostMapping
    public void create(@RequestBody Developer developer) {
	System.out.println(developer);
    }

    /**
     * Modifie partiellement une ressource de type "Developer", ici uniquement
     * la date de naissance, le développeur est identifié par son pseudo.
     * <p>
     * On utilise le verbe "PATCH" pour la modification partielle d'une
     * ressource. Comme pour un "get by id", la pratique est d'utiliser une
     * variable de chemin avec l'identifiant de ressource, ici le pseudo.
     * <p>
     * Dans le cas présent on ne modifie qu'une seule donnée sur le développeur
     * (la date de naissance) mais bien entendu on peut avoir à modifier
     * plusieurs données sur une même ressource. La pratique est d'envoyer un
     * JSON dans le corps de la requête HTTP, tout comme pour une création de
     * ressource ("POST").
     * <p>
     * Il est assez fréquent d'avoir plusieurs "PATCH" sur un même type de
     * ressource, le couple verbe + url devant être unique il faut un moyen de
     * lever toute ambiguité, on peut utiliser un verbe ou un nom dans l'url
     * indiquant au client de l'API ce qui est modifié.
     *
     * @param pseudo le pseudo identifiant une ressource "Developer"
     * @param partial les données partielles d'une ressource "Developer"
     */
    @PatchMapping("/{pseudo}/birth-date")
    public void updateBirthDate(@PathVariable("pseudo") String pseudo,
	    @RequestBody Developer partial) {
	System.out.println("Partial object=" + partial);
	Developer developer = new Developer();
	developer.setPseudo(pseudo); // Variable de chemin
	developer.setFirstName(partial.getFirstName()); // Anomalie
	developer.setLastName("MARSHALL");
	developer.setBirthDate(partial.getBirthDate()); // JSON
	System.out.println("New object=" + developer);
    }
}
