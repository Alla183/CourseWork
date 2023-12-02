package com.example.coursework.repositories;

import com.example.coursework.models.Compositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositorRepository extends JpaRepository<Compositor, Integer> {
}