package fr.formation.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.authentication.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Finds the default role. Does not return an {@code Optional} as we should
     * always have a default role in the data store.
     *
     * @return the default role; {@code null} if none found
     */
    Role findByByDefaultTrue();
}
