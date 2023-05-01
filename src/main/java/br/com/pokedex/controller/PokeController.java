package br.com.pokedex.controller;

import br.com.pokedex.entity.Dto.PokemonDTO;
import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.service.PokeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "Pokemons")
@RestController
@RequestMapping("/pokemons")
public class PokeController {

    @Autowired
    private PokeService pokeService;

    @GetMapping
    public ResponseEntity<Page<PokemonDTO>> pokemonList(@PageableDefault (size = 30) Pageable page) {
        pokeService.startGame();
        Page<PokemonDTO> pokemons = pokeService.listPokemons(page);
        return ResponseEntity.status(HttpStatus.OK).body(pokemons);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pokemon> getAttack(@PathVariable("id") Integer id, String nameAttack) {
        var poke = pokeService.findPokemon(id);
        pokeService.addAttack(poke, nameAttack);
        return ResponseEntity.status(HttpStatus.OK).body(poke);
    }

}
