package com.example.coursework.controllers;

import com.example.coursework.models.Playlist;
import com.example.coursework.models.Track;
import com.example.coursework.services.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/")
    public String getAllPlaylist(Model model) {
        List<Playlist> playlists = playlistService.getAllPlaylist();
        model.addAttribute("playlists", playlists);
        return "playlists";
    }

    @GetMapping("/playlists/{id}")
    public String getPlaylistById(@PathVariable int id, Model model) {
        Playlist playlist = playlistService.getPlaylistById(id);
        model.addAttribute("playlist", playlist);

        return "playlist_info";
    }

    @GetMapping("/playlist_info/{id}")
    public String showPlaylistInfo(@PathVariable int id, Model model) {

        Playlist playlist = playlistService.getPlaylistById(id);
        model.addAttribute("playlist",playlist);

        return "playlist_tracks";
    }

    @GetMapping("/createpl")
    public String createPlaylistForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "createPlaylist";
    }

    @PostMapping("/createp")
    public String createPlaylist(@ModelAttribute Playlist playlist) {
        playlistService.createPlaylist(playlist);
        return "redirect:/";
    }

    @PostMapping("/deletepl/{id}")
    public String deletePlaylist(@PathVariable int id) {
        playlistService.deletePlaylist(id);
        return "redirect:/";
    }

    @PostMapping("/deletetrpl/{playlistId}")
    public String deleteTrackFromPlaylist(@PathVariable int playlistId, @RequestParam("track_id") int trackId) {

        Playlist playlist = playlistService.getPlaylistById(playlistId);

        Set<Track> tracks = playlist.getTracks();

        tracks.removeIf(x -> x.getId() == trackId);
        playlist.setTracks(tracks);

        playlistService.createPlaylist(playlist);

        return "redirect:/playlist_info/" + playlistId;
    }
}
