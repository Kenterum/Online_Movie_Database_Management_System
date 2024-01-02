package MDMS;

import javax.swing.*;

import MDMS.src.MovieDatabase;
import MDMS.src.UserInterface;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MovieDatabase movieDatabase = new MovieDatabase();
                new UserInterface(movieDatabase);
            }
        });
    }
}