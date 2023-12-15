package com.example.laborator78.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AlbumDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumDetailsId;
    private String description;

    public AlbumDetails() {
    }

    public int getAlbumDetailsId() {
        return albumDetailsId;
    }

    public void setAlbumDetailsId(int albumDetailsId) {
        this.albumDetailsId = albumDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
