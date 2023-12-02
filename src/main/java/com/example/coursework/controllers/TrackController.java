package com.example.coursework.controllers;

import com.example.coursework.models.*;
import com.example.coursework.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;
    private final AlbumService albumService;
    private final CompositorService compositorService;
    private final GenreService genreService;
    private final LabelService labelService;
    private final TrackLabelService trackLabelService;
    private final PlaylistService playlistService;
    private final ArtistService artistService;

    @GetMapping("/tracks")
    public String getAllTracks(Model model) {
        List<Track> tracks = null;
        tracks = trackService.getAllTracks();
        model.addAttribute("tracks", tracks);
        return "tracks";
    }
    @GetMapping("/track/{id}")
    public String getTrackById(@PathVariable int id, Model model) {
        Track track = trackService.getTrackById(id);

        model.addAttribute("track", track);
        model.addAttribute("playlists",playlistService.getAllPlaylist());
        model.addAttribute("albums",albumService.getAllAlbums());
        model.addAttribute("artists",artistService.getAllArtists());
        model.addAttribute("labels",labelService.getAll());

        return "track_info";
    }
    @GetMapping("/createTrack/{artistId}")
    public String createTrackForm(Model model, @PathVariable int artistId) {
        model.addAttribute("track", new Track());
        model.addAttribute("albums",albumService.getAllAlbums());
        model.addAttribute("compositors",compositorService.getAll());
        model.addAttribute("genres",genreService.getAll());
        model.addAttribute("labels",labelService.getAll());

        model.addAttribute("artistId",artistId);
        return "createTrack";
    }

    @PostMapping("/createt/{artistId}")
    public String createAlbum(@ModelAttribute Track track, @RequestParam("compositor") int compositorId,
                              @RequestParam("genre") int genreId, @RequestParam("label") int labelId, @PathVariable int artistId,
                              @RequestParam("year_edition") int yearEdition) {

//        track.setGenres(new LinkedHashSet<>(Set.of(genreService.getById(genreId))));
        track.addGenre(genreService.getById(genreId));
        track.addCompositor(compositorService.geById(compositorId));
//        track.setCompositors(new LinkedHashSet<>(Set.of(new Compositor(compositorId))));

//        track.setTrackLabel(new TrackLabel(0,new RecordLabel(labelId),new Artist(artistId),));

//        track.setLabe(new LinkedHashSet<>(Set.of(new Genre(genreId))));

        int trackId = trackService.createTrack(track);
        track.setId(trackId);
        trackLabelService.save(new TrackLabel(0,new RecordLabel(labelId),new Artist(artistId),track,yearEdition));
        return "redirect:/tracks";
    }


    @PostMapping("/update-tracks")
    public String updateTrack(@ModelAttribute("track") Track track, Model model) {

        Album album = albumService.getAlbumById(track.getIdAlbum().getId());
        if (album != null) {
            track.setIdAlbum(album);
        }
        trackService.updateTrack(track);
        TrackLabel trackLabel = track.getTrackLabel();
        trackLabel.setIdTrack(track);
        trackLabelService.save(trackLabel);
        return "redirect:/track/" + track.getId();
    }

    @PostMapping("/deletet/{id}")
    public String deleteTrack(@PathVariable int id) {
        trackService.deleteTrack(id);
        return "redirect:/tracks";
    }
}
