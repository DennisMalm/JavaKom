package com.company.entity;


import lombok.Data;

@Data
public class Moves {

    private String name;
    private String damageType;
    private int accuracy;
    private int power;
    private int pp;


    public Moves(MovesJson movesJson) {
        this.name = movesJson.getName();
        this.damageType = movesJson.getDamage_class().getName();
        this.accuracy = movesJson.getAccuracy();
        this.power = movesJson.getPower();
        this.pp = movesJson.getPp();
    }


}
