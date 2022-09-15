package de.neuefische.webclientrickandmorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RickAndMortyResponseCharacter {
    private List<RickAndMortyCharacter> results;

}
