package br.com.pokedex.controller;

import br.com.pokedex.dto.AttackDto;
import br.com.pokedex.entity.Attack;
import br.com.pokedex.service.AttackService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atacks")
public class AttackController {

    @Autowired
    private AttackService attackService;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<Attack> save(@Valid @RequestBody AttackDto attackDto) {
        var attack = mapper.convertValue(attackDto, Attack.class);
        attackService.saveAttack(attack);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(attack.getId())
                .toUri();
        return ResponseEntity.created(uri).body(attack);
    }

    @GetMapping
    public List<Attack> attackList() {
        List<Attack> attacks = attackService.getAttacks();
        return attacks;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Attack> getById(@PathVariable("id") Integer id) {
        var attackId = attackService.getId(id);
        return ResponseEntity.status(HttpStatus.OK).body(attackId);
    }

}
