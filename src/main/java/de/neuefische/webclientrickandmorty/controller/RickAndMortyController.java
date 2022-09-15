package de.neuefische.webclientrickandmorty.controller;

import de.neuefische.webclientrickandmorty.model.RickAndMortyCharacter;
import de.neuefische.webclientrickandmorty.model.RickAndMortyResponseCharacter;
import de.neuefische.webclientrickandmorty.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    private RickAndMortyService rickAndMortyService;

    @Autowired
    public RickAndMortyController(RickAndMortyService rickAndMortyService){
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping
    public List<RickAndMortyCharacter> getRickAndMortyCharacters(){
        return rickAndMortyService.getRickAndMortyCharacter();
    }

    @GetMapping(path="/character")
    public List<RickAndMortyCharacter> getAliveRickAndMortyCharacters(@RequestParam String status){
        return rickAndMortyService.getAliveRickAndMortyCharacters(status);
    }

    @GetMapping(path="/character/{status}")
    public List<RickAndMortyCharacter> getAliveRickAndMortyCharactersWithPathVariable(@PathVariable String status){
        return rickAndMortyService.getAliveRickAndMortyCharacters(status);
    }

}
