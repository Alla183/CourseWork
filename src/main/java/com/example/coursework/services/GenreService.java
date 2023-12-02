package com.example.coursework.services;

import com.example.coursework.models.Genre;
import com.example.coursework.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public List<Genre> getAll() {

        return genreRepository.findAll();
    }

    public Genre getById(int genreId) {

        return genreRepository.findById(genreId).orElse(null);
    }
}
