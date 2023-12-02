package com.example.coursework.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year", nullable = false)
    private Integer year;

    @OneToMany(mappedBy = "idAlbum")
    private Set<Track> tracks = new LinkedHashSet<>();

}