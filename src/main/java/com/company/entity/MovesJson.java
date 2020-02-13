package com.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovesJson {



    private String name;
    private int power;
    private int pp;
    private int accuracy;
    private AttackType damage_class;

    @Data
    @NoArgsConstructor
    public class AttackType {
        private String name;
    }

    public void moveInfo() {

        System.out.println("Move: " + name);
        System.out.println("Power: " + power);
        System.out.println("Accuracy: " + accuracy);
    }
}
