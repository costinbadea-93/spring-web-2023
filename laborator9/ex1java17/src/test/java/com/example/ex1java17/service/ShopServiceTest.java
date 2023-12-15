package com.example.ex1java17.service;


import com.example.ex1java17.model.Album;
import com.example.ex1java17.model.AlbumDetails;
import com.example.ex1java17.model.Artist;
import com.example.ex1java17.repository.AlbumDetailRepository;
import com.example.ex1java17.repository.AlbumRepository;
import com.example.ex1java17.repository.ArtistRepository;
import com.example.ex1java17.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    @InjectMocks
    private ShopService shopService;

    @Mock
    private AlbumDetailRepository albumDetailRepository;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private ShopRepository shopRepository;


    @Test
    @DisplayName("Running save artist behaviour on happy flow")
    public void saveArtistTest(){
        //arrange
        Artist artist = new Artist("dummy artist");
//        Artist artistResponse = new Artist("response artist");
        when(artistRepository.save(artist)).thenReturn(artist);

        //act
        Artist result = shopService.saveArtist(artist);

        //assert
        assertEquals(artist.getArtistName(), result.getArtistName());
    }

    @Test
    public void saveAlbumTest(){
        //arrange
        int albumDetailsId = 1;
        int artistId = 2;

        Album album = new Album("A1", 5);
        AlbumDetails albumDetails = new AlbumDetails("TestAlbumDetails");
        Artist artist = new Artist("TestArtist");

        when(albumDetailRepository.findById(albumDetailsId)).thenReturn(Optional.of(albumDetails));
        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        when(albumRepository.save(album)).thenReturn(album);


        //act
        Album result = shopService.saveAlbum(album, albumDetailsId, artistId);

        //assert
        assertEquals(result.getArtist().getArtistName(), artist.getArtistName(), "Should be equals");
    }

    @Test
    public void saveSomeAlbumDetailsTest() {
        //arrange

        //act
        RuntimeException result = assertThrows(
                RuntimeException.class,
                () -> shopService.saveSomeAlbumDetails()
        );

        assertEquals(result.getMessage(), "I = 5!!!!!", "should be equals");
    }
}
