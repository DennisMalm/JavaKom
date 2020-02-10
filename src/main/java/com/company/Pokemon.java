package com.company;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Types;
import java.util.List;
@Data
@NoArgsConstructor
public class Pokemon {

    private String name;
    private List<PokemonType> types;

    public void getPokeInfo() {
        //return name + "\n" + types.get(0).getType().getName() + "\n" + types.get(1).getType().getName();

        System.out.println(types.size());
        System.out.println("Name: " + name + "\nTypes:");

        for (int i = 0; i < types.size() ; i++) {
            System.out.println(types.get(i).getType().getName());
        }
        /*for ( PokemonType type : types) {
            System.out.print(type.getType().getName());
        }*/

    }

}
