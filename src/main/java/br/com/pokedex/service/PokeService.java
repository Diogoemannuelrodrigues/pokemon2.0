package br.com.pokedex.service;

import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.exceptions.PokemonNotFoundException;
import br.com.pokedex.repository.PokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class PokeService {

    public static final String LINK = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/";
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
        var list = pokemons;
        int cont = 1;
        for (int i = 0; i < list.size(); i++, cont++) {
            var novo = LINK + "00" + cont + ".png";
            pokemons.get(i).setLinkurl(novo);
            log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            if (i >= 9) {
                var novoD = LINK + "0" + cont + ".png";
                pokemons.get(i).setLinkurl(novoD);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
            if (i > 99) {
                var novoN = LINK + cont + ".png";
                pokemons.get(i).setLinkurl(novoN);
                log.info("########################## - Add link for pokemon {}- ##########################", pokemons.get(i));
            }
        }
        ajustsInSetXp(list);
        return list;
    }

    private void ajustsInSetXp(List<Pokemon> pokemons) {
        setNotEvolutions(pokemons);
        log.info("Add number evolutions for the pokemon");
        setTwoEvolutions(pokemons);
        log.info("Add number evolutions for the pokemon");

        for (Pokemon poke : pokemons) {
            if (poke.getEvolution().equals(2)) {
                poke.setHP(30.0);
                poke.setDefense(10);
                poke.setAgility(13);
                poke.setLevel(10.0);
                poke.setXp(100.0);
            }
            log.info("Add sets parans for pokemon");
        }

        for (Pokemon poke : pokemons) {
            if (poke.getEvolution().equals(1)) {
                poke.setHP(90.0);
                poke.setDefense(60);
                poke.setAgility(60);
                poke.setLevel(40.0);
                poke.setXp(200.0);
            }
            log.info("Add sets parans for pokemon");
        }
    }

        private void setTwoEvolutions(List<Pokemon> pokemons) {

            List<String> namesPoke2 = Arrays.asList("Bulbasaur","Charmander",
                    "Squirtle", "Caterpie", "Weedle",
                    "Pidgey", "Nidoran",
                    "Nidorino", "Oddish",
                    "Poliwag", "Abra",
                    "Machop", "Bellsprout",
                    "Geodude", "Gastley");

            for (String name : namesPoke2) {
                pokemons.stream()
                        .filter(pokemon -> name.equals(pokemon.getName()))
                        .forEach(pokemon -> {
                            pokemon.setEvolution(SECOND_EVOL);
                            log.info("Add Not Evolution for pokemon - {}", pokemon);
                        });
            }


        }



    private void setNotEvolutions(List<Pokemon> pokemons) {
        List<String> namesPoke = Arrays.asList("Butterfree", "Raticate", "Fearow", "Arbok", "Raichu", "Sandslash",
                "Nidoqueen", "Nidoking", "Golbat", "Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth",
                "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Machamp", "Victreebel", "Porygon",
                "Tentacruel", "Golem", "Rapidash", "Dodrio", "Dewgong", "Muk", "Cloyster", "Hypno", "Omanyte", "Kabuto",
                "Kingler", "Electrode", "Exeggutor", "Marowak", "Hitmonlee", "Hitmonchan", "Weezing", "Seaking", "Gloom",
                "Starmie", "Jynx", "Tauros", "Mew", "Lapras", "Ditto", "Vaporeon", "Jolteon", "Vaporeon", "Jolteon",
                "Flareon", "Omastar", "Kabutops", "Snorlax", "Mewtwo", "Articuno", "Zapdos", "Moltres", "Dragonite",
                "Snorlax", "Articuno", "Zapdos", "Moltres", "Gyarados", "Slowpoke", "Hitmonlee", "Hitmonchan", "Lickitung",
                "Chansey", "Tangela", "Kangaskhan", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros",
                "Lapras", "Ditto", "Eevee", "Flareon", "Alakazam", "Slowbro", "Magneton", "Farfetchd", "Gengar", "Onix", "Rhydon",
                "Seadra");

        for (String name : namesPoke) {
            pokemons.stream()
                    .filter(pokemon -> name.equals(pokemon.getName()))
                    .forEach(pokemon -> {
                        pokemon.setEvolution(ZERO_EVOL);
                        log.info("Add Not Evolution for pokemon - {}", pokemon);
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
