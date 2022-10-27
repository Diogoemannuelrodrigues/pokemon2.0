package br.com.pokedex.controller;

import br.com.pokedex.dto.PokemonDto;
import br.com.pokedex.entity.Attack;
import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.service.PokeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokeController {

    @Autowired
    private PokeService pokeService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> pokemonList() {
        pokeService.startGame();
        List<Pokemon> pokemons = pokeService.listPokemons();
        return ResponseEntity.status(HttpStatus.OK).body(pokemons);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pokemon> getAttack(@PathVariable("id") Integer id, String nameAttack) {
        var poke = pokeService.findPokemon(id);
        pokeService.addAttack(poke, nameAttack);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(poke);
    }

//    @GetMapping(value = "/{id}")
//    public Pokemon pokemonInfo(@PathVariable("id") Integer id) {
//        var pokemon = pokeService.pokeInfo(id);
//        return pokemon;
//    }

}
