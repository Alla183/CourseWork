package com.example.coursework.controllers;

import com.example.coursework.models.Artist;
import com.example.coursework.services.*;
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
public class ArtistController {
    private final ArtistService artistService;
    private final CountryService countyService;
    private final RoleService roleService;
    private final GenreService genreService;
    private final GroupService groupService;

    @GetMapping("/artists")
    public String getAllArtists(Model model) {
        List<Artist> artists = artistService.getAllArtists();
        model.addAttribute("artists", artists);
        return "artists";
    }

    @GetMapping("/createar")
    public String createArtistForm(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("countries",countyService.getAll());
        model.addAttribute("roles",roleService.getAll());
        model.addAttribute("genres",genreService.getAll());
        model.addAttribute("groups",groupService.getAll());
        return "createArtist";
    }

    @PostMapping("/createart")
    public String createArtist(@ModelAttribute Artist artist) {
        artistService.createArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("/artist_tracks/{id}")
    public String getAlbumTrack(@PathVariable int id, Model model) {
//        List<ArtistTrackDTO> artistTrackDTOS = artistService.getArtistTrack(id);
        Artist artist = artistService.getArtistById(id);
        model.addAttribute("artist", artist);
        return "artist_tracks";
    }

    @PostMapping("/deleteart/{id}")
    public String deleteArtist(@PathVariable int id,Model model) {

        artistService.deleteById(id);

        return "redirect:/artists";
    }
}
