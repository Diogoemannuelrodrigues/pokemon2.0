package br.com.pokedex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "attack")
public class Attack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameAttack;

    private Double strength;

    private String category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_pokemon")
    private Pokemon pokemon;

    private String description;

}
