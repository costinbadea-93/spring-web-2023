package com.example.ex1java17.service;

import com.example.ex1java17.model.AlbumDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ShopServiceIT {

    @Autowired
    private ShopService shopService;


    @Test
    @DisplayName("Create album details it")
    public void createAlbumDetails(){
        //arrange
        AlbumDetails albumDetails = new AlbumDetails("Test Alumb details");
        //act
        AlbumDetails result = shopService.saveAlbumDetails(albumDetails);
        //assert
        assertEquals(albumDetails.getDescription(), result.getDescription(), "should be equals");
    }
}
