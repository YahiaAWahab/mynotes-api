package com.example.mynotes.controller;

import com.example.mynotes.model.AppUser;
import com.example.mynotes.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(AccountsRepository accountsRepository, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public void register(@RequestBody AppUser appUser) {
        accountsRepository.createNewUser(appUser.getUsername().toLowerCase(), passwordEncoder.encode(appUser.getPassword()), true);
        accountsRepository.createNewAuthority(appUser.getUsername());
    }
}
