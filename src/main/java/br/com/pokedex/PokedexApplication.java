package br.com.pokedex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class PokedexApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
