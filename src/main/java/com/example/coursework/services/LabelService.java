package com.example.coursework.services;

import com.example.coursework.models.RecordLabel;
import com.example.coursework.repositories.RecordLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {

    private final RecordLabelRepository labelRepository;

    public List<RecordLabel> getAll() {

        return labelRepository.findAll();
    }
}
