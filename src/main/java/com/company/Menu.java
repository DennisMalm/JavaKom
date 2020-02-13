package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    private static Scanner read = new Scanner(System.in);

    static boolean menu() throws IOException, SQLException {
        System.out.println(
                "                                               \n" +
                        "Vad vill du göra?                      \n" +
                        "--------------------------             \n" +
                        "1. Print all.                          \n" +
                        "2. Search for an actor.                \n" +
                        "3. ----------------                    \n" +
                        "4. ----------------                    \n" +
                        "5. ----------------                    \n" +
                        "6. ----------------                    \n" +
                        "7. Stäng programmet.                     "
        );
        return handleInput(menuInput());
    }

    static boolean handleInput(Enums.Choice input) throws SQLException, IOException {

        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        switch (input) {
            case PRINTALL:
                break;
            case SEARCH:
                break;
            case ADD:
                break;
            case REMOVE:
                break;
            case EDIT:
                break;
            case MOVIES:
                break;
            case QUIT:
                System.out.println("Avslutar.");
                return exitProg();
        }
        return false;
    }

    private static Enums.Choice menuInput() {
        while (true) {
            try {
                int input = (read.nextInt());
                if (input > 0 && input <= 7) {
                    return Enums.intToChoice.get(input);
                }
            } catch (InputMismatchException ime) {
                read.nextLine();
            }
            System.out.printf(Utility.reTry);
        }
    }

    private static boolean exitProg() {
        return true;
    }
}
