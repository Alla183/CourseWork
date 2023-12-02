package com.example.coursework.repositories;

import com.example.coursework.models.TrackLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackLabelRepository extends JpaRepository<TrackLabel, Integer> {
}