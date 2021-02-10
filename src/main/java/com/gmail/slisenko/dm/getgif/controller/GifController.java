package com.gmail.slisenko.dm.getgif.controller;

import com.gmail.slisenko.dm.getgif.service.GetGifService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {
    private final GetGifService service;

    public GifController(@Qualifier("getGifService") GetGifService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("gif", service.getRandomGif());
        return "index";
    }

}
