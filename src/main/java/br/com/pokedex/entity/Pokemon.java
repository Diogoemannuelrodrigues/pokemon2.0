package br.com.pokedex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer defense;
    private Integer agility;
    private Double level;

    @Column(length = 2048)
    private String linkurl;

    //This is for look the numbers of evolutions the pokemon
    private Integer Evolution;

    //The pokemon gains xp according to the fight
    private Double xp;

    //pokemon is already born with health at 30, as it grows and gaining xp increases;
    private Double HP;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "types")
    private Set<Type> types = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pokemon", cascade = CascadeType.ALL)
    private Set<Attack> attacks = new HashSet<>();

    public Set<Type> getTypes() {
        return types.stream()
                .map(x -> Type.toEnum(x.getCod()))
                .collect(Collectors.toSet());
    }
}
