package com.example.coursework.services;

import com.example.coursework.models.Playlist;
import com.example.coursework.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylistById(int id){
        return playlistRepository.findById(id).orElse(null);
    }

    public void createPlaylist(Playlist playlist){
        playlistRepository.save(playlist);
    }
    public void deletePlaylist(int idPlaylist){
        playlistRepository.deleteById(idPlaylist);
    }

}
