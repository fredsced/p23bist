package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;

public interface SkillService {

    SkillView getById(Long id);

    void create(SkillCreate dto);

    SkillView getByName(String name);
}
