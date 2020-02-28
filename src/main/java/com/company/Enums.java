package com.company;

import java.util.Map;

public class Enums {

    enum Choice {
        PRINTALL,
        REMOVE,
        SEARCH,
        QUIT,
        ADD,
        MOVIES,
        EDIT,
        FIGHT,

    }
    public static Map<Integer, Choice> intToChoice = Map.of(
            1, Choice.ADD,
            2, Choice.REMOVE,
            3, Choice.PRINTALL,
            4, Choice.FIGHT,
            5, Choice.SEARCH,
            6, Choice.EDIT,
            7, Choice.QUIT
    );
}