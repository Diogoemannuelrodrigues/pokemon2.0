package br.com.pokedex.service;

import br.com.pokedex.entity.Dto.PokemonDTO;
import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.exceptions.PokemonNotFoundException;
import br.com.pokedex.repository.PokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Service
public class PokeService extends MapperService {

    public static final String LINK = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/";

    private final PokeRepository pokeRepository;

    @Autowired
    public PokeService(PokeRepository pokeRepository) {
        this.pokeRepository = pokeRepository;
    }

    @Autowired
    private AttackService attackService;

    public Pokemon savePokemon(Pokemon pokemon) {
        if (nonNull(pokemon)) {
            return pokeRepository.save(pokemon);
        }
        return null;
    }

    public List<PokemonDTO> listPokemons() {
        return pokeRepository.findAllPokemonsById().stream().map(pokemon -> getConverter().map(pokemon, PokemonDTO.class)).collect(Collectors.toList());
    }

    public String startGame() {
        var findAllPokemons = pokeRepository.findAll();
        log.info("########################## - Find all pokemons - ##########################");
        var pokesUrls = addLinkUrlForPokemons2(findAllPokemons);
        pokeRepository.saveAll(pokesUrls);
        return "The game is about to start";
    }

    public Pokemon findPokemon(Integer id) {
        return pokeRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id, " Not found"));
    }

    public Pokemon addAttack(Pokemon poke, String nameAttack) {
        var attack = attackService.findAttackByName(nameAttack);
        var setAttack = poke.getAttacks();
        setAttack.add(attack);
        poke.setAttacks(setAttack);
        savePokemon(poke);
        return null;
    }


    private List<Pokemon> addLinkUrlForPokemons(List<Pokemon> pokemons) {
        //Refatorar
        //Ajustar tirar o list e colocar um set
        var list = pokemons;
        int cont = 1;
        for (int i = 0; i < list.size(); i++, cont++) {
            var primeiros10 = LINK + "00" + cont + ".png";
            pokemons.get(i).setLinkurl(primeiros10);
            log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            if (i >= 9) {
                var menosQue99 = LINK + "0" + cont + ".png";
                pokemons.get(i).setLinkurl(menosQue99);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
            if (i > 99) {
                var maioresQue100 = LINK + cont + ".png";
                pokemons.get(i).setLinkurl(maioresQue100);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
        }
        return list;
    }

    private List<Pokemon> addLinkUrlForPokemons2(List<Pokemon> pokemons) {
        Collections.sort(pokemons, comparing(Pokemon::getId).thenComparing(Pokemon::getLevel));

        return pokemons.stream().map(pokemon -> {
            int cont = 1;
            for (int i = 0; i < pokemons.size(); i++, cont++) {
                var addLinkUrlPokemons = LINK + "00" + cont + ".png";
                pokemons.get(i).setLinkurl(addLinkUrlPokemons);
            }
            return pokemon;
        }).collect(Collectors.toList());
    }

    public Pokemon pokemonById(Integer id) {
        var poke = pokeRepository.findById(id);
        if (nonNull(poke)) {
            return poke.get();
        }
        throw new PokemonNotFoundException("Pokemon not found");
    }
}