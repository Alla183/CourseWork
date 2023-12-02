package com.example.coursework.services;


import com.example.coursework.models.Album;
import com.example.coursework.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;


    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(int id){
        return albumRepository.findById(id).orElse(null);
    }

    public void createAlbum(Album album){
        albumRepository.save(album);
    }
    public void deleteAlbum(int idAlbum){
        albumRepository.deleteById(idAlbum);
    }

//    public  List<AlbumTrackDTO> getAlbumTrack(int id_album){return albumRepository.getAlbumTrack(id_album);}
}