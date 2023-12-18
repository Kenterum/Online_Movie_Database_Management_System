import java.io.IOException;

public class UserTest {

    public static void testUserRegistration() {
        System.out.println("Testing User Registration:");
        createAndTestUser("testUser", "testPassword");
        createAndTestUser("anotherUser", "anotherPassword");
    }

    public static void testUserLogin() {
        System.out.println("\nTesting User Login:");
        validateLogin("testUser", "testPassword"); //Expected Output: Success
        validateLogin("testUser", "wrongPassword"); //Expected Output: Fail
        validateLogin("nonExistingUser", "testPassword"); //Expected Output: Fail
    }

    private static void createAndTestUser(String username, String password) {
        User newUser = new User(username, password);
        try {
            newUser.saveUser();
            System.out.println("User registered successfully: " + username);
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