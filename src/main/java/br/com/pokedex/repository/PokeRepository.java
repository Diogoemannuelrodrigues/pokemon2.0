package br.com.pokedex.repository;

import br.com.pokedex.entity.Dto.PokemonDTO;
import br.com.pokedex.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, Integer> {


    @Query(value = "select * from Pokemon pk order by id", nativeQuery = true)
    List<Pokemon> findAllPokemonsById();
}
