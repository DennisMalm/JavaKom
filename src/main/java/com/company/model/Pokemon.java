package com.company.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Pokemon {

    private String name;
    private HashMap stats;
    private List types;
    private int health;
    private int hp;
    private int speed;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private boolean winner;

    public Pokemon(PokemonJson pokemonJson) {
        this.name = pokemonJson.getName();
        this.stats = pokemonJson.getStats();
        this.types = pokemonJson.getType();
        this.health = (int) stats.get("hp");
        this.hp = (int) stats.get("hp");
        this.speed = (int) stats.get("speed");
        this.attack = (int) stats.get("attack");
        this.defense = (int) stats.get("defense");
        this.specialAttack = (int) stats.get("special-attack");
        this.specialDefense = (int) stats.get("special-defense");
        
    }

    public void testInfo() {
        System.out.println("---THIS IS A JAVA OBJECT---.");
        System.out.println(types.size());
        System.out.println(name + "\nTypes:");
        types.forEach(System.out::println);
        System.out.println("Health: " + health);
        System.out.println("Speed: " + speed);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Special attack: " + specialAttack);
        System.out.println("Special defense: " + specialDefense);

    }

    public void reset(){
        this.hp = this.health;
    }
    public boolean attack(Pokemon defending) {

        return defending.defend(attack / 3);

    }

    public boolean defend(double attackPower) {
        this.hp -= attackPower - (1);
        System.out.println(String.format(this.name + " takes %s damage.", (attackPower - 1)));
        System.out.println(hp + " left.");
        if (hp <= 0) {
            System.out.println(this.name + " is dead.");
            System.out.println(hp + " left.");

            return true;
        }
        return false;
    }

}
