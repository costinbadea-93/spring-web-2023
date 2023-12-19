package com.example.ex1java17.service;

import com.example.ex1java17.model.Album;
import com.example.ex1java17.model.AlbumDetails;
import com.example.ex1java17.model.Artist;
import com.example.ex1java17.model.Shop;
import com.example.ex1java17.repository.AlbumDetailRepository;
import com.example.ex1java17.repository.AlbumRepository;
import com.example.ex1java17.repository.ArtistRepository;
import com.example.ex1java17.repository.ShopRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopService {

    private final AlbumDetailRepository albumDetailRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final ShopRepository shopRepository;

    public ShopService(AlbumDetailRepository albumDetailRepository, AlbumRepository albumRepository, ArtistRepository artistRepository, ShopRepository shopRepository) {
        this.albumDetailRepository = albumDetailRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.shopRepository = shopRepository;
    }

    public Artist saveArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public AlbumDetails saveAlbumDetails(AlbumDetails albumDetails){
        return albumDetailRepository.save(albumDetails);
    }

    public Album saveAlbum(Album album, int albumDetailsId, int artistId){
        AlbumDetails albumDetails = albumDetailRepository.findById(albumDetailsId)
                .orElseThrow(() -> new RuntimeException("invalid album details id"));

        Artist artist = artistRepository.findById(artistId).orElseThrow(() ->
                new RuntimeException("invalid artist id"));

        album.setAlbumDetails(albumDetails);
        album.setArtist(artist);

        return albumRepository.save(album);
    }

    public Shop saveShop(Shop shop, List<Integer> albumIds){
        List<Album> albums = albumRepository.findAllById(albumIds);
        shop.setAlbumList(albums);
        return shopRepository.save(shop);
    }

    @Transactional
    public void saveSomeAlbumDetails(){
        for(int i = 0 ; i < 10 ; i ++) {
            AlbumDetails albumDetails = new AlbumDetails("Album details " + i);
            albumDetailRepository.save(albumDetails);
            if(i == 5) {
                throw new RuntimeException("I = 5!!!!!");
            }
        }
    }

}
