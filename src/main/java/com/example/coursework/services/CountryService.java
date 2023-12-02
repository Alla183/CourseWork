package com.example.coursework.services;

import com.example.coursework.models.Country;
import com.example.coursework.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAll() {

        return countryRepository.findAll();
    }
}
