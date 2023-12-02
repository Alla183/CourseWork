package com.example.coursework.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "compositor")
@NoArgsConstructor
@AllArgsConstructor
public class Compositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compositor", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "track_compositor",
            joinColumns = @JoinColumn(name = "id_compositor"),
            inverseJoinColumns = @JoinColumn(name = "id_track"))
    private Set<Track> tracks = new LinkedHashSet<>();

    public Compositor(Integer id) {
        this.id = id;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }
}