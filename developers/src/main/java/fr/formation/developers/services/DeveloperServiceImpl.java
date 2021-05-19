package fr.formation.developers.services;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Override
    public DeveloperCreate getByPseudo(String pseudo) {
	DeveloperCreate developer = new DeveloperCreate();
	developer.setPseudo(pseudo);
	developer.setFirstName("Frank");
	developer.setLastName("MARSHALL");
	LocalDate date = LocalDate.of(1974, 12, 26);
	developer.setBirthDate(date);
	return developer;
    }

    @Override
    public void create(DeveloperCreate developer) {
	System.out.println(developer);
    }

    @Override
    public void updateBirthDate(String pseudo, @Valid DeveloperUpdate partial) {
	// System.out.println("Partial object=" + partial);
	// DeveloperCreate developer = new DeveloperCreate();
	// developer.setPseudo(pseudo); // Variable de chemin
	// developer.setFirstName(partial.getFirstName()); // Anomalie
	// developer.setLastName("MARSHALL");
	// developer.setBirthDate(partial.getBirthDate()); // JSON
	System.out.println("Update birth date of: " + pseudo
		+ " with new date : " + partial.getBirthDate());
    }
}
