package br.com.pokedex.dto;

import br.com.pokedex.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {

    private String name;

    private Set<Type> types = new HashSet<>();

    private Integer numberEvolution;
}
