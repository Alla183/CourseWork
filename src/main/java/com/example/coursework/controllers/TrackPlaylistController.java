package com.example.coursework.controllers;

import com.example.coursework.models.Playlist;
import com.example.coursework.models.Track;
import com.example.coursework.services.PlaylistService;
import com.example.coursework.services.TrackPlaylistService;
import com.example.coursework.services.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class TrackPlaylistController {
    private final TrackPlaylistService trackPlaylistService;
    private final PlaylistService playlistService;
    private final TrackService trackService;

    @PostMapping("/playlists/add-track/{trackId}")
    public String addTrackToPlaylist(@RequestParam int playlistId, @PathVariable int trackId) {
        Playlist playlist = playlistService.getPlaylistById(playlistId);
        playlist.getTracks().add(trackService.getTrackById(trackId));
        playlistService.createPlaylist(playlist);
        return "redirect:/track/" + trackId;
    }

    @PostMapping("/playlists/delete/{playlistId}/{trackId}")
    public String delete(@PathVariable int playlistId, @PathVariable int trackId) {

        Playlist playlist = playlistService.getPlaylistById(playlistId);
        Set<Track> tracks = playlist.getTracks();
        tracks.remove(trackService.getTrackById(trackId));
        playlist.setTracks(tracks);

        playlistService.createPlaylist(playlist);

        return "redirect:/";
    }

    /*@GetMapping("/allTrackPlaylist")
    public String getAllPlaylist(Model model) {
        List<Playlist> playlists = playlistService.getAllPlaylist();
        List<PlaylistTrackDurationDTO> list = new ArrayList<>();

        for (Playlist playlist : playlists) {

            for (Track track : playlist.getTracks()) {
                list.add(new PlaylistTrackDurationDTO(playlist.getId(),playlist.getName(),track.getId(),track.getName(),track.getDuration()));
            }
        }

        model.addAttribute("list", list);
        return "trackPlaylist";
    }*/

}
