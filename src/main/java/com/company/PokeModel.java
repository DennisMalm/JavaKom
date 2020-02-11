package com.company;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PokeModel {

    private String name;
    private int height;
    private int weight;
    private int id;
    private List<PokemonType> types;
    private List<PokeMoves> moves;
    private List<pokeStats> stats;

    public void getPokeInfo() {

        System.out.println(types.size());
        System.out.println(name + "\nTypes:");
        types.forEach(type -> System.out.println(type.getType().getName()));
        System.out.println(moves.get(0).getMove().getName());
        System.out.println(stats.get(0).base_stat + " " + stats.get(0).stat.name);
        //  Gets all pokemon moves.
        //  moves.forEach(move -> System.out.println(move.getMove().getName()));
    }

    @Data
    @NoArgsConstructor
    private class pokeStats{
        private int base_stat;
        private SpecificStat stat;

        @Data
        @NoArgsConstructor
        private class SpecificStat{
            private String name;
        }
    }

    @Data
    @NoArgsConstructor
    private class PokeMoves {
        private AttackMove move;

        @Data
        @NoArgsConstructor
        private class AttackMove {
            private String name;
            private String moveUrl;
        }
    }

    @Data
    @NoArgsConstructor
    private class PokemonType {
        private Element type;

        @Data
        @NoArgsConstructor
        private class Element {
            private String name;
        }
    }


}
