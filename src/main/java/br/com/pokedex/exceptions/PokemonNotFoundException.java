package br.com.pokedex.exceptions;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(Integer id, String s) {
    }

    public PokemonNotFoundException( String s) {
    }
}
