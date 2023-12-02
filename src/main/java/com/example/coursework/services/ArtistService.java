package com.example.coursework.services;


import com.example.coursework.models.Artist;
import com.example.coursework.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public void createArtist(Artist artist){
        artistRepository.save(artist);
    }

//    public  List<ArtistTrackDTO> getArtistTrack(int id_artist) {
//        return artistRepository.getArtistTrack(id_artist);
//
//    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

    public Artist getArtistById(int id) {

        return artistRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {

        artistRepository.deleteById(id);
    }
}
