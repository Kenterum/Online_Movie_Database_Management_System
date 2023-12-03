import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        UserTest.testUserRegistration();
        UserTest.testUserLogin();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MovieDatabase movieDatabase = new MovieDatabase();
                new UserInterface(movieDatabase);
            }
        });
    }
}
