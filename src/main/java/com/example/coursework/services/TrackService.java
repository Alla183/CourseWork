package com.example.coursework.services;

import com.example.coursework.models.Track;
import com.example.coursework.repositories.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    public Track getTrackById(int id){
        return trackRepository.findById(id).orElse(null);
    }

    public int createTrack(Track track){
        return trackRepository.save(track).getId();
    }

    public void deleteTrack(int idTrack){
        trackRepository.deleteById(idTrack);}

    public void updateTrack(Track track){
        trackRepository.updateTrack(track.getDuration(),track.getIdAlbum(),track.getName(),track.getId());
    }
}
