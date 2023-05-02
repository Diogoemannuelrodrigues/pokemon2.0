package br.com.pokedex.entity.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonDTO {

    private Integer id;
    private String name;
    private Integer defense;
    private Integer agility;
    private Double level;
    private String linkUrl;
}
