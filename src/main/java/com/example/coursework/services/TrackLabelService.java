package com.example.coursework.services;

import com.example.coursework.models.TrackLabel;
import com.example.coursework.repositories.TrackLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackLabelService {

    private final TrackLabelRepository trackLabelRepository;


    public void save(TrackLabel trackLabel) {

        trackLabelRepository.save(trackLabel);
    }

    public void update(TrackLabel trackLabel) {

    }

}
