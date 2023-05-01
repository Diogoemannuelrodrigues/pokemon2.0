package br.com.pokedex.controller;

import br.com.pokedex.dto.AttackDto;
import br.com.pokedex.entity.Attack;
import br.com.pokedex.service.AttackService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@Api(tags = "Attacks")
@RestController
@RequestMapping("/atacks")
public class AttackController {

    @Autowired
    private AttackService attackService;

    @Autowired
    private ObjectMapper mapper;

    @ApiOperation("Salva um attack")
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
    @ApiOperation("Lista todos os attacks")
    @GetMapping
    public List<Attack> attackList() {
        return attackService.getAttacks();
    }

    @ApiOperation("Busca um attack por id")
    @GetMapping(value = "{id}")
    public ResponseEntity<Attack> getById(@PathVariable("id") Integer id) {
        var attackId = attackService.getId(id);
        return ResponseEntity.status(HttpStatus.OK).body(attackId);
    }

}
