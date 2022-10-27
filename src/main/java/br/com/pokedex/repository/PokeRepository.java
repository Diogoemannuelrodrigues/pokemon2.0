package br.com.pokedex.repository;

import br.com.pokedex.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeRepository extends JpaRepository<Pokemon, Integer> {
}
