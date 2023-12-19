package com.example.ex1java17.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlbumDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumDetailsId;
    private String description;

    public AlbumDetails() {
    }

    public AlbumDetails(String description) {
        this.description = description;
    }

    public AlbumDetails(int albumDetailsId, String description) {
        this.albumDetailsId = albumDetailsId;
        this.description = description;
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
