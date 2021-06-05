package fr.formation.authentication.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.formation.authentication.domain.dtos.AccountCreate;
import fr.formation.authentication.domain.dtos.AccountLogin;
import fr.formation.authentication.domain.entities.Account;
import fr.formation.authentication.domain.entities.Role;
import fr.formation.authentication.repositories.AccountRepository;
import fr.formation.authentication.repositories.RoleRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accounts;

    private final RoleRepository roles;

    public AccountServiceImpl(AccountRepository accounts,
	    RoleRepository roles) {
	this.accounts = accounts;
	this.roles = roles;
    }

    @Override
    public void create(AccountCreate inputs) {
	Account entity = new Account();
	entity.setUsername(inputs.getUsername());
	entity.setPassword(inputs.getPassword());
	entity.setEnabled(true);
	Role defaultRole = roles.findByByDefaultTrue();
	entity.setRole(defaultRole);
	accounts.save(entity);
    }

    @Override
    public void login(AccountLogin inputs) {
	String username = inputs.getUsername();
	Optional<Account> entity = accounts
		.findByUsernameAndEnabledTrue(username);
	if (entity.isPresent()) {
	    System.out.println("Login success!");
	} else {
	    System.out.println("Account not found!");
	}
    }
}
