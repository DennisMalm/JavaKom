package com.company.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Pokemon {

    private String name;
    private HashMap stats;
    private List types;
    private List<Moves> moves;
    private int health;
    private int hp;
    private int speed;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;

    public Pokemon(PokemonJson pokemonJson, List<Moves> moves) {
        this.name = pokemonJson.getName();
        this.stats = pokemonJson.getStats();
        this.types = pokemonJson.getType();
        this.health = (int) stats.get("hp");
        this.speed = (int) stats.get("speed");
        this.attack = (int) stats.get("attack");
        this.defense = (int) stats.get("defense");
        this.specialAttack = (int) stats.get("special-attack");
        this.specialDefense = (int) stats.get("special-defense");
        this.moves = moves;


    }

    public void testInfo() {
        System.out.println("This is an Java Objekt.");
        System.out.println(types.size());
        System.out.println(name + "\nTypes:");
        types.forEach(System.out::println);
        System.out.println(health);
        System.out.println(speed);
        System.out.println(attack);
        System.out.println(specialAttack);
        System.out.println(defense);
        System.out.println(specialDefense);
        System.out.println(moves.get(5).getName() + " " + moves.get(5).getPower() + " " + moves.get(5).getAccuracy());
        //moves.forEach(move -> System.out.println(move.getName() + move.getPower()) );


    }

    public boolean attack(Pokemon defending) {
        String name = moves.get(1).getName();
        double power = moves.get(1).getPower();
        int accuracy = moves.get(1).getPower();
        System.out.println(defending.defend((((2 / 5) * power * attack / defending.getDefense() / 50) + 2)));
        return defending.defend((((2 / 5) * power * attack / defending.getDefense() / 50) + 2));
        //defending.setHp((int) (((2 / 5) * power * attack / defending.getDefense() / 50) + 2));
    }
    public boolean defend(double attackPower){
        this.hp -= attackPower;
        System.out.println(this.name + " defends.");
        if (hp <= 0){
            System.out.println(this.name + "is dead.");
            return true;
        }
        return false;
    }

}
