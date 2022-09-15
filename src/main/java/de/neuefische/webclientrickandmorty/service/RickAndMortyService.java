package de.neuefische.webclientrickandmorty.service;

import de.neuefische.webclientrickandmorty.model.RickAndMortyCharacter;
import de.neuefische.webclientrickandmorty.model.RickAndMortyResponseCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RickAndMortyService {

    private WebClient client = WebClient.create("https://rickandmortyapi.com/api/");
    public List<RickAndMortyCharacter> getRickAndMortyCharacter() {
        RickAndMortyResponseCharacter responseCharacter =
                client.get()
                        .uri("character")
                        .retrieve()
                        .toEntity(RickAndMortyResponseCharacter.class)
                        .block()
                        .getBody();
        return responseCharacter.getResults();
    }

    public List<RickAndMortyCharacter> getAliveRickAndMortyCharacters(String status) {
        RickAndMortyResponseCharacter responseCharacter =
                client.get()
                        .uri("character?status="+status)
                        .retrieve()
                        .toEntity(RickAndMortyResponseCharacter.class)
                        .block()
                        .getBody();
        return responseCharacter.getResults();
    }
}
