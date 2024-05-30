package com.unijorge.ods16.controller;

import com.unijorge.ods16.model.Role;
import com.unijorge.ods16.model.records.UserSummary;
import com.unijorge.ods16.repository.UserRepository;
import com.unijorge.ods16.security.CurrentUser;
import com.unijorge.ods16.security.UserPrincipal;
import com.unijorge.ods16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserRepository repository;

    private final UserService service;

    @Autowired
    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }


    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(), currentUser.getEmail());
    }

    @GetMapping("/permissao")
    public Set<Role> buscarPermissao(@CurrentUser UserPrincipal currentUser) {
        return service.buscarPermissao(currentUser.getId());
    }
}
