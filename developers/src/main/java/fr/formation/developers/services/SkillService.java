package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;

/**
 * L'interface du service pour gérer les "Skill". Autrement dit, comme pour les
 * controller, on a une interface (et son implémentation) pour chaque entité en
 * respectant les mêmes conventions de nommage en préfixant par le type de
 * l'entité.
 * <p>
 * L'interface expose sous forme de méthodes les différents services qu'on
 * souhaite exposer aux controllers. La couche service a des responsabilités
 * différentes et complémentaires par rapport à la couche controller, selon les
 * besoins:
 * <ul>
 * <li>Appeler des APIs externes
 * <li>Faire des calculs basés sur les inputs et/ou des données extraites de la
 * base
 * <li>Convertir les DTO en objets métier et inversement
 * <li>S'appuyer sur la couche repository pour interagir avec la base de données
 * </ul>
 */
public interface SkillService {

    SkillView getById(Long id);

    void create(SkillCreate dto);

    SkillView getByName(String name);
}
