package com.company;

import java.util.Map;

public class Enums {

    enum Choice {
        PRINTALL,
        SEARCH,
        QUIT,
        REMOVE,
        ADD,
        MOVIES,
        EDIT,
    }
    public static Map<Integer, Choice> intToChoice = Map.of(
            1, Choice.PRINTALL,
            2, Choice.SEARCH,
            3, Choice.ADD,
            4, Choice.REMOVE,
            5, Choice.EDIT,
            6, Choice.MOVIES,
            7, Choice.QUIT
    );
}