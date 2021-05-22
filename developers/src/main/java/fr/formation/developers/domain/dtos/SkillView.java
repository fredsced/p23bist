package fr.formation.developers.domain.dtos;

/**
 * Un DTO en lecture seule (du point de vue du client), il représente des
 * données à retourner au client. Il n'y a pas de validation dans ce qu'on peut
 * appeler des "vues", il ne s'agit pas d'inputs mais typiquement d'une
 * représentation de données préexistantes en base de données.
 */
public class SkillView {

    private String name;

    public SkillView() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "SkillView [name=" + name + "]";
    }
}
