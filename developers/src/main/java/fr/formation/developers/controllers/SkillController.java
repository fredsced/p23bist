package fr.formation.developers.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;
import fr.formation.developers.services.SkillService;

/**
 * Une classe qui expose un ensemble de ressources de type "Skill". Le terme
 * "ressources" est utilisé dans un contexte d'API Rest car un "serveur de
 * ressources" de met pas à disposition uniquement des données stockées dans une
 * base. Les ressources peuvent être des données calculées sans accéder à une
 * base, des fichiers stockés sur disque ou encore des données qui proviennent
 * d'autres API. C'est donc un terme plus large pour désigner les informations
 * misent à disposition aux clients de l'API.
 * <p>
 * Pour indiquer à Spring que cette classe contient des déclarations de
 * "endpoints" il faut l'annoter "@RestController". En cas d'oublie et si la
 * classe n'est même pas du tout annotée avec une annotation Spring, la classe
 * sera ignorée lors du scan des packages au démarrage.
 * <p>
 * Dans un "@RestController" on déclare ensuite les méthodes qui vont gérer le
 * service demandé sur le type de ressource, nous avons ici deux services, un
 * pour récupérer une compétence par son identifiant, et un service pour créer
 * une nouvelle compétence. Pour être exécuté suite à l'appel d'un client HTTP,
 * on annote chaque méthode avec une annotation de mapping de requête HTTP. Le
 * nommage de ces annotations est simple, c'est le verbe HTTP suivi du suffixe
 * mapping. Il faut donc se concentrer sur les verbes HTTP, les principaux étant
 * :
 * <ul>
 * <li>GET
 * <li>POST
 * <li>PUT
 * <li>PATCH
 * <li>DELETE
 * <li>OPTIONS
 * </ul>
 * Les cinq premiers verbes étant utilisés dans les opérations dites de type
 * CRUD (Create, Read/Retrieve, Update et Delete).
 * <p>
 * En terme Rest, un endpoint est un "identifiant" composé du verbe ("GET",
 * "POST") et du chemin vers la ressource ("/skills/{id}", "/skills"). Un
 * identifiant est par définition unique et ce dans toute l'application, pas
 * uniquement dans un controller, d'où l'importance de la qualité du nommage et
 * de l'organisation du code.
 */
@RestController
@RequestMapping("/skills")
public class SkillController {

    // @Autowired // JEE = @Inject
    /*
     * Pour injecter le service par constructeur (vs champ avec @Autowired) on
     * déclare le champ du type souhaité qui peut être marqué "final" ce qui
     * évite de potentiels effets de bords car un champ "final" ne peut être
     * réassigné. Il ne peut être assigné qu'à la déclaration de la variable ou
     * à la construction, ce que nous faisons ici.
     */
    private final SkillService service;

    /**
     * Construit un "SkillController" avec le service spécifié. C'est Spring qui
     * instancie le controller.
     *
     * @param service une instance de "SkillService" instancié et injectée par
     *        Spring
     */
    public SkillController(SkillService service) {
	this.service = service;
    }

    /**
     * Retourne la compétence dont l'identifant est "id". En Java nous déclarons
     * retourner un objet (instance) de type "Skill" mais Spring, en s'appuyant
     * sur la librairie Jackson (qui fait partie des dépendances du starter
     * web), va convertir (sérialiser) l'objet Java en JSON.
     * <p>
     * Dans le chemin, "{id}" est la syntaxe pour déclarer une variable de
     * chemin, c'est une pratique courante en Rest pour récupérer un identifiant
     * (mais pas que) de ressource dans le cas d'un "GET". La valeur est ensuite
     * récupérée en Java grâce à la déclaration de l'argument de la méthode (ici
     * "id" avec son type). Au besoin, on peut déclarer plusieurs variables de
     * chemin, pour lever l'ambiguité et réaliser le mapping entre la variable
     * dans le chemin et l'argument on annote chaque argument avec
     * "@PathVariable". On précise le nom de la variable en paramètre de
     * l'annotation.
     *
     * @param id un identifiant de compétence
     * @return la compétence dont l'identifiant est "id"
     */
    @GetMapping("/{id}")
    public SkillView getById(@PathVariable("id") Long id) {
	return service.getById(id);
    }

    /**
     * Créé une nouvelle compétence à partir des données récupérées du JSON.
     * Spring s'appuie ici aussi sur Jackson pour convertir (désérialiser) le
     * JSON reçu en objet Java de type "Skill".
     * <p>
     * Un client d'API peut envoyer des données de différentes manières, ici le
     * client envoi une représentation de compétence au format JSON dans le
     * corps de la requête HTTP, d'où l'ajout de l'annotation "@RequestBody" sur
     * l'argument de la méthode. Notons que "@RequestBody" porte bien son nom.
     * Elle indique à Spring que les données à mapper avec l'objet se trouve
     * dans le corps de la requête et pas ailleurs.
     *
     * @param skill les données JSON reçues converties en une instance de
     *        "Skill"
     */
    @PostMapping
    public void create(@Valid @RequestBody SkillCreate dto) {
	/*
	 * Le controller a assuré toutes ses responsabilités, directement ou
	 * indirectement (exposition du endpoint, conversion du Json en instance
	 * de DTO, validation), on confie le reste des traitements à la couche
	 * service.
	 */
	service.create(dto); // Au service de faire le reste du traitement
    }

    @GetMapping("/{name}/by-name")
    public SkillView getByName(@PathVariable("name") String name) {
	return service.getByName(name);
    }
}
