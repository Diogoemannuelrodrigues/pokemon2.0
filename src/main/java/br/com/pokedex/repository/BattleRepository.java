package br.com.pokedex.repository;

import br.com.pokedex.entity.Battles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BattleRepository extends JpaRepository<Battles, UUID> {
}
