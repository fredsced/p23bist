package fr.formation.authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.authentication.domain.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Indicates whether or not an account exists with given username.
     *
     * @param username a username
     * @return {@code true} if an account exists; {@code false} otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Finds an optional enabled account with given username.
     *
     * @param username a username to find related account with
     * @return an optional account
     */
    Optional<Account> findByUsernameAndEnabledTrue(String username);
}
