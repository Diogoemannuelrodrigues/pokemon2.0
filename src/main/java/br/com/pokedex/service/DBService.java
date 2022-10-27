package br.com.pokedex.service;

import br.com.pokedex.repository.PokeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Slf4j
@Service
public class DBService {

    @Autowired
    private PokeRepository pokeRepository;


    public void instantiateDatabase() throws ParseException {

    }

}
