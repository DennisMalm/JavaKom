package com.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class PokemonJson {

    private String name;
    private int height;
    private int weight;
    private int id;
    
    public List<PokemonType> types;
    public List<PokeMoves> moves;
    public List<PokeStats> stats;
    public List<MovesJson> jsonMove;

    public HashMap getStats(){

        HashMap<String, Integer> statMap = new HashMap<>();

        for (PokeStats stat : stats){
            statMap.put(stat.getStat().getName(),stat.getBase_stat());
        }
        return statMap;
    }

    public List getType() {
        List<String> sendType = new ArrayList<>();

        types.forEach(type -> sendType.add(type.getType().getName()));
        return sendType;
    }

    public List moveUrl() {
        List<String> moveList = new ArrayList<>();

        moves.forEach(move -> moveList.add(move.getMove().getUrl()));
        /*for (PokeMoves move : moves) {
            moveList.add(move.getMove().getUrl());
        }*/
        return moveList;
    }


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
    private class PokeStats {
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
            private String url;
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
