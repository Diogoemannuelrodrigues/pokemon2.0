package br.com.pokedex.service;

import br.com.pokedex.entity.Battles;
import br.com.pokedex.entity.Pokemon;
import br.com.pokedex.repository.BattleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class Metricas {

    private static final Double LEVEL1 = 20.0;
    private static final Double LEVEL2 = 40.0;

    @Autowired
    private BattleRepository battleRepository;

    @Autowired
    private PokeService pokeService;

    public String adversarios(Integer id1, Integer id2) {

        var adversario1 = pokeService.findPokemon(id1);
        var adversario2 = pokeService.findPokemon(id2);

        log.info("A batalha será entre {} x {}", adversario1.getName(), adversario2.getName());

        log.info("Começa quem tem vantagem {}", quemComeça(id1, id2));

        var stringBuilder = new StringBuilder();
        stringBuilder.append("");

        return null;

    }

    public Battles batalha() {
        return null;
    }


    private Pokemon quemComeça(Integer pokeId1, Integer pokeId2) {
        var ad1 = pokeService.findPokemon(pokeId1);
        var ad2 = pokeService.findPokemon(pokeId2);

//        ad1.getTypes().forEach(t -> t.hasAdvantages(ad2));

        var vencedor = quemTiraOnumeroMaior(ad1, ad2);
        return vencedor;
    }

    private Pokemon quemTiraOnumeroMaior(Pokemon ad1, Pokemon ad2) {
        var uuid = UUID.randomUUID().toString();
        return null;
    }
//
//    public boolean verificaVida(Pokemon pokemon) {
//        if (pokemon.getLife() <= 1) {
//            retornarParaPoquebola(pokemon);
//            return true;
//        }
//        return false;
//    }

    private void retornarParaPoquebola(Pokemon pokemon) {
        log.info("Retornando para poquebola {}", pokemon.getName());
    }

    public Pokemon verificaTipoAgua(Pokemon pokemon, Pokemon poke2) {
        var poke = pokemon.getTypes().toString().toUpperCase();
        var poke1 = poke2.getTypes().toString().toUpperCase();

        if (poke.equals("AGUA") && poke1.equals("TERRA") || poke1.equals("ROCHA") || poke1.equals("FOGO")) {
            return pokemon;
        }
        return poke2;
    }

    public Pokemon xp(Pokemon pokemonGanhou, Pokemon pokemonPerdeu) {
        //ajustar a formula do xp
        var xp = pokemonPerdeu.getXp();
        var novoxp = pokemonGanhou.getXp() + xp;
        pokemonGanhou.setHP(novoxp);
        return pokemonGanhou;
    }

    public Pokemon evolution(Pokemon pokemon) {
        List<String> nomes = new ArrayList<>();
        var lista = listaPokemons();

        String s = getNextName(pokemon, lista);
        if (pokemon.getLevel().equals(LEVEL1) && pokemon.getEvolution() > 1) {
            pokemon.setName(s);

            pokeService.savePokemon(pokemon);
        }
        return pokemon;
    }

    private String getNextName(Pokemon pokemon, List<String> lista) {
        int index = lista.indexOf(pokemon.getName());
        String s = lista.get(index + 1);
        return s;
    }

    private List<String> listaPokemons() {
        List<String> namePokemons = List.of("Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle",
                "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
                "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans",
                "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoranfe", "Nidorina", "Nidoqueen",
                "Nidoranma", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff",
                "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect",
                "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck",
                "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhril", "Poliwrath", "Abra",
                "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel",
                "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke",
                "Slowbro", "Magnemite", "Magneton", "Farfetchd", "Doduo", "Dodrio", "Seel", "Dewgong",
                "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar", "Onix",
                "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor",
                "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn",
                "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking",
                "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir",
                "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon",
                "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax",
                "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew");
        return namePokemons;
    }


}
