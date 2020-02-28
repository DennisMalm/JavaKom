package com.company.model;

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
    public List<PokeStats> stats;

    public HashMap getStats() {

        HashMap<String, Integer> statMap = new HashMap<>();

        for (PokeStats stat : stats) {
            statMap.put(stat.getStat().getName(), stat.getBase_stat());
        }
        return statMap;
    }

    public List getType() {
        List<String> sendType = new ArrayList<>();
        types.forEach(type -> sendType.add(type.getType().getName()));
        return sendType;
    }

    public void getJsonInfo() {

        System.out.println(types.size());
        System.out.println(name + "\nTypes:");
        types.forEach(type -> System.out.println(type.getType().getName()));
        System.out.println(stats.get(0).base_stat + " " + stats.get(0).stat.name);

    }

    @Data
    @NoArgsConstructor
    private class PokeStats {
        private int base_stat;
        private SpecificStat stat;

        @Data
        @NoArgsConstructor
        private class SpecificStat {
            private String name;
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

    @Data
    @NoArgsConstructor
    private class sprites {
        private String back_default;
        private String back_female;
        private String back_shiny;
        private String back_shiny_female;
        private String front_default;
        private String front_female;
        private String front_shiny;
        private String front_shiny_female;
    }

}
