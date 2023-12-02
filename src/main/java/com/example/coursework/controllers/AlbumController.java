package com.example.coursework.controllers;


import com.example.coursework.models.Album;
import com.example.coursework.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/albums")
    public String getAllAlbums(Model model) {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @GetMapping("/create")
    public String createAlbumForm(Model model) {
        model.addAttribute("album", new Album());
        return "createAlbum";
    }

    @PostMapping("/createa")
    public String createAlbum(@ModelAttribute Album album) {
        albumService.createAlbum(album);
        return "redirect:/albums";
    }

    @PostMapping("/deletea/{id}")
    public String deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(id);
        return "redirect:/albums";
    }
    @GetMapping("/album_tracks/{id}")
    public String getAlbumTrack(@PathVariable int id, Model model) {
        Album album = albumService.getAlbumById(id);
        model.addAttribute("album", album);
        return "album_tracks";
    }
}
