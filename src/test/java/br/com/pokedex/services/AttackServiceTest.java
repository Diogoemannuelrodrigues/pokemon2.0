package br.com.pokedex.services;

import br.com.pokedex.entity.Attack;
import br.com.pokedex.repository.AttackRepository;
import br.com.pokedex.service.AttackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttackServiceTest {

    @Mock
    private AttackRepository attackRepository;
    @InjectMocks
    public AttackService attackService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("verify is the search the attack on the service by name")
    public void verificaFindAttackByName() {
        var attack = createAttack();

        attackService.findAttackByName("tests");
        assertEquals("tests", attack.getNameAttack());
    }

    @Test
    @DisplayName("verify is the search the attack on the service")
    public void verificaNull() {
        var result = attackService.findAttackByName(" ");
        assertNull(result);
    }

    public Attack createAttack() {
        return Attack.builder().nameAttack("tests").description("test").id(1).build();
    }

    @Test
    @DisplayName("Find All the atacks")
    public void verificaGetAttacks() {
        var atack = createAttack();
        when(attackRepository.findAll()).thenReturn(Collections.singletonList(atack));
        var result = attackService.getAttacks();
        assertNotNull(result);
        assertEquals(Arrays.asList(atack), result);
    }

    @Test
    @DisplayName("Find All the atacks by Id")
    public void verifyGetAttacksById() {
        //when
        var attack = createAttack();
        when(attackRepository.findById(Mockito.any())).thenReturn(Optional.of(attack));

        //then
        var result = attackService.getId(attack.getId());

        //return
        assertNotNull(result);
        assertEquals(attack, result);
    }

    @Test
    @DisplayName("Save the atack success")
    public void verifyIfSaveTheAttack() {
        //when
        var attack = createAttack();
        when(attackRepository.save(Mockito.any())).thenReturn(attack);

        //then
        var result = attackService.saveAttack(attack);
        //return
        assertNotNull(result);
    }

    @Test
    @DisplayName("Save the atack Fail")
    public void verifyIfSaveTheAttackFail() {
        //when
        var attack = createAttack();
        attack.setNameAttack("");
        //then
        var result = attackService.saveAttack(attack);
        //return
        assertNull(result);
    }

}


