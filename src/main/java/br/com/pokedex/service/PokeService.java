package br.com.pokedex.service;

import br.com.pokedex.entity.Attack;
import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.exceptions.PokemonNotFoundException;
import br.com.pokedex.repository.PokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class PokeService {

    private static final int ZERO_EVOL = 0;
    private static final int FIRTS_EVOL = 1;
    private static final int SECOND_EVOL = 2;

    @Autowired
    private PokeRepository pokeRepository;

    @Autowired
    private AttackService attackService;

    public Pokemon savePokemon(Pokemon pokemon) {
        if (nonNull(pokemon)) {
            return pokeRepository.save(pokemon);
        }
        return null;
    }

    public List<Pokemon> listPokemons() {
        return pokeRepository.findAll();
    }

    public String startGame() {
        var findAllPokemons = pokeRepository.findAll();
        log.info("########################## - Find all pokemons - ##########################");
        var pokesUrls = addLinkUrlForPokemons(findAllPokemons);
        pokeRepository.saveAll(pokesUrls);
        return "The game is about to start";
    }

    public Pokemon findPokemon(Integer id) {
        return pokeRepository
                .findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id, " Not found"));
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
        String link = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/";
        var list = pokemons;
        int cont = 1;
        for (int i = 0; i < list.size(); i++, cont++) {
            var novo = link + "00" + cont + ".png";
            pokemons.get(i).setLinkurl(novo);
            log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            if (i >= 9) {
                var novoD = link + "0" + cont + ".png";
                pokemons.get(i).setLinkurl(novoD);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
            if (i > 99) {
                var novoN = link + cont + ".png";
                pokemons.get(i).setLinkurl(novoN);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
        }
        ajustsInSetXp(list);
        return list;
    }

    private void ajustsInSetXp(List<Pokemon> pokemons) {
        setNotEvolutions(pokemons);
        setTwoEvolutions(pokemons);

        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getEvolution().equals(SECOND_EVOL)) {
                pokemons.get(i).setHP(30.0);
                pokemons.get(i).setDefense(10);
                pokemons.get(i).setAgility(13);
                pokemons.get(i).setLevel(10.0);
                pokemons.get(i).setXp(100.0);
                log.info("Add sets parans for pokemon - {}", pokemons.get(i));
            } else if (pokemons.get(i).getEvolution().equals(ZERO_EVOL)) {
                pokemons.get(i).setHP(90.0);
                pokemons.get(i).setDefense(60);
                pokemons.get(i).setAgility(60);
                pokemons.get(i).setLevel(40.0);
                pokemons.get(i).setXp(200.0);
                log.info("Add sets parans for pokemon - {}", pokemons.get(i));
            } else {
                pokemons.get(i).setHP(60.0);
                pokemons.get(i).setDefense(40);
                pokemons.get(i).setAgility(40);
                pokemons.get(i).setLevel(20.0);
                pokemons.get(i).setXp(150.0);
                pokemons.get(i).setEvolution(FIRTS_EVOL);
                log.info("Add sets parans for pokemon - {}", pokemons.get(i));
            }
        }
    }


    private void setNotEvolutions(List<Pokemon> pokemons) {
        List<String> namesPoke = Arrays.asList("Butterfree", "Raticate", "Fearow", "Arbok", "Raichu", "Sandslash",
                "Nidoqueen", "Nidoking", "Golbat","Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth",
                "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Machamp", "Victreebel","Porygon",
                "Tentacruel", "Golem", "Rapidash", "Dodrio", "Dewgong", "Muk", "Cloyster", "Hypno", "Omanyte", "Kabuto",
                "Kingler", "Electrode", "Exeggutor", "Marowak", "Hitmonlee", "Hitmonchan", "Weezing", "Seaking", "Gloom",
                "Starmie", "Jynx", "Tauros", "Mew", "Lapras", "Ditto", "Vaporeon", "Jolteon", "Vaporeon", "Jolteon",
                "Flareon", "Omastar", "Kabutops", "Snorlax", "Mewtwo", "Articuno", "Zapdos", "Moltres", "Dragonite",
                "Snorlax", "Articuno", "Zapdos", "Moltres", "Gyarados", "Slowpoke", "Hitmonlee", "Hitmonchan","Lickitung",
                "Chansey", "Tangela", "Kangaskhan","Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros",
                "Lapras", "Ditto", "Eevee", "Flareon", "Alakazam", "Slowbro", "Magneton", "Farfetchd", "Gengar", "Onix", "Rhydon",
                "Seadra"
        );

        for (String name : namesPoke) {
            pokemons.stream()
                    .filter(pokemon -> name.equals(pokemon.getName()))
                    .forEach(pokemon -> {
                        pokemon.setEvolution(ZERO_EVOL);
                        log.info("Add Not Evolution for pokemon - {}", pokemon);
                    });
        }
    }


    private void setTwoEvolutions(List<Pokemon> pokemons) {
        List<String> pokes2Evolutions = Arrays.asList("Bulbasaur", "Charmander", "Squirtle",
                "Caterpie", "Weedle", "Pidgey", "Rattata", "Spearow", "Horsea",
                "Nidoran", "Clefairy", "Vulpix", "Jigglypuff",
                "Zubat", "Oddish", "Poliwag", "Abra", "Bellsprout", "Geodude", "Gastly",
                "Dratini");


        for (String name : pokes2Evolutions) {
            pokemons.stream()
                    .filter(pokemon -> name.equals(pokemon.getName().trim()))
                    .forEach(pokemon -> {
                        pokemon.setEvolution(SECOND_EVOL);
                        log.info("Have two Evolution for pokemon - {}", pokemon);
                    });
        }
    }

    public Pokemon pokeInfo(Integer id) {
        var poke = pokeRepository.findById(id);
        if (nonNull(poke)) {
            return poke.get();
        }
        throw new PokemonNotFoundException("Pokemon not found");
    }
}
