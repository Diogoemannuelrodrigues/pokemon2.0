package br.com.pokedex.services;

import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.repository.PokeRepository;
import br.com.pokedex.service.PokeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PokeserviceTest {
    @Autowired
    private PokeService pokeService;

    @Mock
    private PokeRepository pokeRepositoryMock;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.pokeService = new PokeService(pokeRepositoryMock);
    }

    @Test
    public void testFindById(){
        var poke = Pokemon.builder().name("Pikachu").build();
        Mockito.when(this.pokeRepositoryMock.findById(Mockito.any())).thenReturn(Optional.ofNullable(poke));
        var result = pokeRepositoryMock.findById(1);
        assertEquals(poke.getName(), result.get().getName());
    }


}
