package fr.formation.authentication.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.authentication.domain.dtos.AccountCreate;
import fr.formation.authentication.domain.dtos.AccountLogin;
import fr.formation.authentication.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
	this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody AccountCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody AccountLogin inputs) {
	service.login(inputs);
    }
}
