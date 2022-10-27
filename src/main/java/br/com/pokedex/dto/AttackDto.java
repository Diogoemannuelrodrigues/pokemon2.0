package br.com.pokedex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttackDto {

    private Integer id;

    private String nameAttack;

    private Double strength;

    private String description;

}
