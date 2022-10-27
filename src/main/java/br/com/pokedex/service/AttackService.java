package br.com.pokedex.service;

import br.com.pokedex.entity.Attack;
import br.com.pokedex.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class AttackService {

    @Autowired
    private AttackRepository attackRepository;

    public List<Attack> getAttacks() {
        return attackRepository.findAll();
    }

    public Attack getId(Integer id) {
        var attack = attackRepository.findById(id);

        if (nonNull(attack)) {
            return attack.get();
        }
        return null;
    }

    public Attack saveAttack(Attack attack) {

        if (nonNull(attack)) {
            return attackRepository.save(attack);
        }
        return null;
    }


    public Attack findAttackByName(String nameAttack) {
        if (!nameAttack.isBlank() || !nameAttack.isEmpty()) {
            var attack = attackRepository.findByNameAttack(nameAttack);
            return attack;
        }
        return null;
    }

}
