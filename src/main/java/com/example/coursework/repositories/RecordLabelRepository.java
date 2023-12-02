package com.example.coursework.repositories;

import com.example.coursework.models.RecordLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer> {
}