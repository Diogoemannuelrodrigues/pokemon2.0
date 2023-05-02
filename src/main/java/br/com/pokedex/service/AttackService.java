package br.com.pokedex.service;

import br.com.pokedex.entity.Attack;
import br.com.pokedex.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttackService {

    @Autowired
    private AttackRepository attackRepository;

    public List<Attack> getAttacks() {
        return attackRepository.findAll();
    }

    public Attack getId(Integer id) {
        var attack = attackRepository.findById(id);
        return attack.orElse(null);
    }

    public Attack saveAttack(Attack attack) {
        if(attack.getNameAttack().isBlank() || attack.getNameAttack().isEmpty()){
            return null;
        }
        return attackRepository.save(attack);
    }


    public Attack findAttackByName(String nameAttack) {
        if (nameAttack.isBlank() || nameAttack.isEmpty()) {
            return null;
        }
        var attack = attackRepository.findByNameAttack(nameAttack);
        return attack;
    }

}
