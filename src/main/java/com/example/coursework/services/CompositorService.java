package com.example.coursework.services;

import com.example.coursework.models.Compositor;
import com.example.coursework.repositories.CompositorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositorService {

    private final CompositorRepository compositorRepository;

    public List<Compositor> getAll() {

        return compositorRepository.findAll();
    }

    public Compositor geById(int compositorId) {

        return compositorRepository.findById(compositorId).orElse(null);
    }
}
