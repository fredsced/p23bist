package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;

public interface DeveloperService {

    DeveloperCreate getByPseudo(String pseudo);

    void create(DeveloperCreate developer);

    void updateBirthDate(String pseudo, DeveloperUpdate partial);
}
