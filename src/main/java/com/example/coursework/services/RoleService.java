package com.example.coursework.services;

import com.example.coursework.models.Role;
import com.example.coursework.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getAll() {

        return roleRepository.findAll();
    }
}
