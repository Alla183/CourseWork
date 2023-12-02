package com.example.coursework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_track", nullable = false)
    private Integer id;

    @Column(name = "duration")
    private String duration;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_album", nullable = false)
    private Album idAlbum;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tracks", cascade = CascadeType.PERSIST)
    private Set<Compositor> compositors = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "tracks", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "tracks")
    private Set<Playlist> playlists = new LinkedHashSet<>();

    @OneToOne(mappedBy = "idTrack")
    private TrackLabel trackLabel;

    public void addGenre(Genre genre){
        this.genres.add(genre);
        genre.addTrack(this);
    }

    public void addCompositor(Compositor compositor){
        this.compositors.add(compositor);
        compositor.addTrack(this);
    }

  /*  public void removeComment(Comment comment){
        this.comments.remove(comment);
        comment.setTopic(null);
    }*/
}