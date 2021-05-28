package fr.formation.developers.services;

import org.springframework.stereotype.Service;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperView;
import fr.formation.developers.domain.dtos.IDeveloperView;
import fr.formation.developers.domain.entities.Developer;
import fr.formation.developers.repositories.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository repo;

    public DeveloperServiceImpl(DeveloperRepository repo) {
	this.repo = repo;
    }

    @Override
    public DeveloperView getByPseudo(String pseudo) {
	Developer entity = repo.findByPseudo(pseudo).get();
	DeveloperView view = new DeveloperView();
	view.setPseudo(entity.getPseudo());
	view.setFirstName(entity.getFirstName());
	view.setLastName(entity.getLastName());
	view.setBirthDate(entity.getBirthDate());
	return view;
    }

    @Override
    public void create(DeveloperCreate dto) {
	Developer entity = new Developer();
	entity.setPseudo(dto.getPseudo());
	entity.setFirstName(dto.getFirstName());
	entity.setLastName(dto.getLastName());
	entity.setBirthDate(dto.getBirthDate());
	repo.save(entity);
    }

    /**
     * Une des possibilités que nous avons, et assez répandue, pour mettre à
     * jour une entité (donc déjà persistée) et dans un premier temps de la
     * récupérer grâce à un "findByXxx" (générlement l'id), d'appeler les
     * setters pour mettre à jour les propriétés concernées puis de sauvegarder
     * l'entité avec son nouvel état (ici nouvelle date de naissance).
     */
    @Override
    public void updateBirthDate(String pseudo, DeveloperUpdate partial) {
	Developer entity = repo.findByPseudo(pseudo).get();
	entity.setBirthDate(partial.getBirthDate());
	repo.save(entity);
    }

    @Override
    public IDeveloperView find() {
	String firstName = "Frank";
	String lastName = "MARSHALL";
	return repo.findByFirstNameAndLastName(firstName, lastName).get();
    }
}
