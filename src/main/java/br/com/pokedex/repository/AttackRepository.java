package br.com.pokedex.repository;

import br.com.pokedex.entity.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<Attack, Integer> {

    Attack findByNameAttack(String attack);
}
