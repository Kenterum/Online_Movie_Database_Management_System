package MDMS;

import java.io.IOException;

import MDMS.src.User;

public class UserTest {

    public static void main(String[] args) {
        testUserRegistration();
        testUserLogin();
    }

    public static void testUserRegistration() {
        System.out.println("Testing User Registration:");
        createAndTestUser("testUser", "testPassword"); // Register user for the first time
        createAndTestUser("testUser", "testPassword"); // Attempt to register the same user again
        createAndTestUser("anotherUser", "anotherPassword"); // Register a different user
    }

    public static void testUserLogin() {
        System.out.println("\nTesting User Login:");
        validateLogin("testUser", "testPassword"); // Expected Output: Success
        validateLogin("testUser", "wrongPassword"); // Expected Output: Fail
        validateLogin("nonExistingUser", "testPassword"); // Expected Output: Fail
    }

    private static void createAndTestUser(String username, String password) {
        try {
            if (User.userExists(username)) {
                System.out.println("User already exists: " + username);
            } else {
                User newUser = new User(username, password);
                newUser.saveUser();
                System.out.println("User registered successfully: " + username);
            }
        } catch (IOException e) {
            System.out.println("Failed to register user: " + username);
            e.printStackTrace();
        }
    }

    private static void validateLogin(String username, String password) {
        try {
            if (User.validateLogin(username, password)) {
                System.out.println("Login successful for user: " + username);
            } else {
                System.out.println("Login failed for user: " + username);
            }
        } catch (IOException e) {
            System.out.println("Error during login for user: " + username);
            e.printStackTrace();
        }
    }
}
