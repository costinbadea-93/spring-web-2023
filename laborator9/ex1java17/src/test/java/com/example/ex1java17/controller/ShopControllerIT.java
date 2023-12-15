package com.example.ex1java17.controller;

import com.example.ex1java17.model.AlbumDetails;
import com.example.ex1java17.repository.AlbumDetailRepository;
import com.example.ex1java17.repository.AlbumRepository;
import com.example.ex1java17.repository.ArtistRepository;
import com.example.ex1java17.repository.ShopRepository;
import com.example.ex1java17.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = ShopServiceController.class)
public class ShopControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper= new ObjectMapper();

    @MockBean
    private ShopService shopService;

    @MockBean
    private AlbumDetailRepository albumDetailRepository;

    @MockBean
    private AlbumRepository albumRepository;

    @MockBean
    private ArtistRepository artistRepository;

    @MockBean
    private ShopRepository shopRepository;

    @Test
    public void createAlbumDetails() throws Exception {
        //arrange
        AlbumDetails albumDetails = new AlbumDetails("Some album details");
        when(shopService.saveAlbumDetails(albumDetails)).thenReturn(albumDetails);

        //act
        //assert
        mockMvc.perform(
                post("/shops/albumDetails/new")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(albumDetails))
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//                .andExpect(jsonPath("$.description").value(albumDetails.getDescription()));
    }

}
