package fr.formation.authentication.services;

import fr.formation.authentication.domain.dtos.AccountCreate;
import fr.formation.authentication.domain.dtos.AccountLogin;

public interface AccountService {

    void create(AccountCreate inputs);

    void login(AccountLogin inputs);
}
