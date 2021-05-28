package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperView;
import fr.formation.developers.domain.dtos.IDeveloperView;

public interface DeveloperService {

    DeveloperView getByPseudo(String pseudo);

    void create(DeveloperCreate developer);

    void updateBirthDate(String pseudo, DeveloperUpdate partial);

    IDeveloperView find();
}
