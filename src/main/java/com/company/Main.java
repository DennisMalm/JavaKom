package com.company;


import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        boolean stop;
        do {
            stop = Menu.menu();
        } while (!stop);
    }
}
