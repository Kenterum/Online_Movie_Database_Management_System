import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MovieTest mBase = new MovieTest();

        // Test Add
        MovieTest.testAdd(mBase);

        // Test Remove
        MovieTest.testRemove(mBase);

        // Test Retrieve
        MovieTest.testRetrieve(mBase);

        // Test User Registration
        UserTest.testUserRegistration();

        // Test User Login
        UserTest.testUserLogin();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MovieDatabase movieDatabase = new MovieDatabase();
                new UserInterface(movieDatabase);
            }
        });
    }
}