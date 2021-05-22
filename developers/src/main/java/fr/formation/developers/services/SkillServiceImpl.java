package fr.formation.developers.services;

import org.springframework.stereotype.Service;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;
import fr.formation.developers.domain.entities.Skill;
import fr.formation.developers.repositories.SkillRepository;

/**
 * L'implémentation de l'interface du service (même principe pour tous les
 * services).
 * <p>
 * Doit être annotée "@Service" et déclare généralement l'injection d'un
 * reprository correspondant pour interagir avec la base données sur l'entité
 * concernée ("Skill").
 */
@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    // Injection du repository par constructeur
    public SkillServiceImpl(SkillRepository repo) {
	this.repo = repo;
    }

    @Override
    public SkillView getById(Long id) {
	/*
	 * On utilise le repository pour récupérer l'entité grâce à l'id.
	 */
	Skill skill = repo.findById(id).get();
	/*
	 * On ne retourne pas directement l'entité mais un DTO, ici nommé
	 * "SkillView". Il faut copier les données de l'entité vers le DTO grâce
	 * aux getters d'un côté et les setters de l'autre.
	 */
	SkillView view = new SkillView();
	view.setName(skill.getName());
	return view;
    }

    @Override
    public void create(SkillCreate dto) {
	/*
	 * On construit une nouvelle instance de "Skill", on assigne le ou les
	 * inputs déjà validés à partir du DTO.
	 */
	Skill skill = new Skill();
	skill.setName(dto.getName());
	// On utilise le repository pour persister l'entité
	repo.save(skill);
    }

    @Override
    public SkillView getByName(String name) {
	// Comme pour getById mais sur un autre critère (cf. "SkillRepository")
	Skill skill = repo.findByName(name).get();
	SkillView view = new SkillView();
	view.setName(skill.getName());
	return view;
    }
}
