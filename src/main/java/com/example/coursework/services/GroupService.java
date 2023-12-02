package com.example.coursework.services;

import com.example.coursework.models.Group;
import com.example.coursework.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> getAll() {

        return groupRepository.findAll();
    }
}
