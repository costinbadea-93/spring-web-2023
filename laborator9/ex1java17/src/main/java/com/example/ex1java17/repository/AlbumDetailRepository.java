package com.example.ex1java17.repository;

import com.example.ex1java17.model.AlbumDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDetailRepository extends JpaRepository<AlbumDetails, Integer> {
}
