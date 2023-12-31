import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class UserInterface extends JFrame {
    private MovieDatabase movieDatabase;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public UserInterface(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
        createUI();
    }

    private void createUI() {
        setTitle("Movie Database System");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Username:"), constraints);

        constraints.gridx = 1;
        panel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Password:"), constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);

        constraints.gridy = 3;
        panel.add(registerButton, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            if (User.validateLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Unable to login.");
            e.printStackTrace();
        }
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User newUser = new User(username, password);

        try {
            newUser.saveUser();
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: Unable to register user.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        new UserInterface(movieDatabase);
    }
}