package com.example.ex1java17.controller;

import com.example.ex1java17.model.Album;
import com.example.ex1java17.model.AlbumDetails;
import com.example.ex1java17.model.Artist;
import com.example.ex1java17.model.Shop;
import com.example.ex1java17.service.ShopService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopServiceController {

    @Autowired
    private ShopService shopService;


    @PostMapping("/artist/new")
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist){
        return ResponseEntity.ok().body(shopService.saveArtist(artist));
    }

    @PostMapping("/albumDetails/new")
    public ResponseEntity<AlbumDetails> saveAlbumDetails(@RequestBody AlbumDetails albumDetails){
        AlbumDetails savedAlbumDetails = shopService.saveAlbumDetails(albumDetails);
        return ResponseEntity.ok().body(savedAlbumDetails);
    }

    @PostMapping("/album/new")
    public ResponseEntity<Album> saveAlbum(@RequestBody Album album,
                                           @RequestParam int albumDetailsId,
                                           @RequestParam int artistId){
        return ResponseEntity.ok()
                .body(shopService.saveAlbum(album, albumDetailsId, artistId));
    }

    @PostMapping("/shop/new")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop,
                                         @RequestParam List<Integer> albumDetailsId){
        return ResponseEntity.ok().body(shopService.saveShop(shop,albumDetailsId));
    }
}
