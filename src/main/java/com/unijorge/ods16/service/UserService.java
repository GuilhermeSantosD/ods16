package com.unijorge.ods16.service;

import com.unijorge.ods16.model.Role;
import com.unijorge.ods16.model.User;
import com.unijorge.ods16.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {


    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Set<Role> buscarPermissao (Long id){
        User user = repository.findById(id).get();
        return user.getRoles();
    }


}
