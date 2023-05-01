package br.com.pokedex.services;

import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.repository.PokeRepository;
import br.com.pokedex.service.PokeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PokeserviceTest {
    @InjectMocks
    private PokeService pokeService;

    @Mock
    private PokeRepository pokeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("testing find by Id")
    public void testFindById(){
        //when
        var poke = Pokemon.builder().name("Pikachu").id(1).build();
        Mockito.when(pokeRepository.findById(Mockito.any())).thenReturn(Optional.of(poke));
        //then
        var result = pokeService.findPokemon(poke.getId());
        //return
        assertEquals(poke.getName(), result.getName());
    }


    @Test
    @DisplayName("Find the pokemon by Id - Success")
    public void getPokemonById() {
        //when
        var pokemon = cratePokemon();
        when(pokeRepository.findById(Mockito.any())).thenReturn(Optional.of(pokemon));
        //then
        var result = pokeService.findPokemon(pokemon.getId());
        //return
        assertNotNull(result);
    }

    @Test(expected = Exception.class)
    @DisplayName("Find the pokemon by Id - Fail")
    public void getPokemonByIdFail() {
        //when
        Pokemon pokemon = new Pokemon();
        when(pokeRepository.findById(Mockito.any())).thenReturn(null);
        //then
        var result = pokeService.findPokemon(pokemon.getId());
        //return
        assertNotNull(result);
    }

    @Test
    @DisplayName("Save the pokemon by Id - Sucess")
    public void getPokemonSave() {
        //when
        var pokemon = cratePokemon();
        when(pokeRepository.save(Mockito.any())).thenReturn(pokemon);
        //then
        var result = pokeService.savePokemon(pokemon);
        //return
        assertNotNull(result);

    }

    @Test
    @DisplayName("Save the pokemon by Id - Fail")
    public void getPokemonSaveFail() {
        //when

        //then
        var result = pokeService.savePokemon(null);
        //return
        assertNull(result);

    }

    private Pokemon cratePokemon() {
        return Pokemon.builder()
                .id(1)
                .build();
    }


}
