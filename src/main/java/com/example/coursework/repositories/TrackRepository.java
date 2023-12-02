package com.example.coursework.repositories;

import com.example.coursework.models.Album;
import com.example.coursework.models.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    @Transactional
    @Modifying
    @Query("update Track t set t.duration = ?1, t.idAlbum = ?2, t.name = ?3 where t.id = ?4")
    void updateTrack(String duration, Album idAlbum,String name ,Integer id);
}