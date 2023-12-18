import java.io.*;

public class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void saveUser() throws IOException {
        System.out.println("Saving user: " + username); 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/users.csv", true))) {
            bw.write(username + "," + password);
            bw.newLine();
            System.out.println("User saved."); 
        }
    }
    

    public static boolean validateLogin(String username, String password) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data/users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    
}