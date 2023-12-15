package com.example.ex1java17.controller;

import com.example.ex1java17.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopServiceController {

    @Autowired
    private ShopService shopService;


    @GetMapping("/details")
    public void addAlbumDetails() {
        shopService.saveSomeAlbumDetails();
    }
}
