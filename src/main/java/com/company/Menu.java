package com.company;

import com.company.controller.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    private static Scanner read = new Scanner(System.in);

    static boolean menu() throws IOException, SQLException, InterruptedException {
        System.out.println(
                "                                               \n" +
                        "Vad vill du göra?                      \n" +
                        "--------------------------             \n" +
                        "1. Add a fighter to the roster.        \n" +
                        "2. Remove a fighter.                   \n" +
                        "3. Check fighter roster.               \n" +
                        "4. Start match.                        \n" +
                        "5. ----------------                    \n" +
                        "6. ----------------                    \n" +
                        "7. Exit.                                 "
        );
        return handleInput(menuInput());
    }

    static boolean handleInput(Enums.Choice input) throws SQLException, IOException, InterruptedException {

        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        Controller controller = new Controller();

        switch (input) {
            case ADD:
                controller.createPokemon();
                break;
            case REMOVE:
                break;
            case PRINTALL:
                controller.checkRoster();
                break;
            case FIGHT:
                controller.startMatch();
                break;
            case EDIT:
                break;
            case MOVIES:
                break;
            case QUIT:
                System.out.println("Exiting.");
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
