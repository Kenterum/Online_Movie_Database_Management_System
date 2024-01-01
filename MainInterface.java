import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainInterface extends JFrame {

    private String username;
    private MovieDatabase movieDatabase;
    private JTable movieTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public MainInterface(String username, MovieDatabase movieDatabase) {
        this.username = username;
        this.movieDatabase = movieDatabase;
        initializeUI();
        loadDataFromDatabase();
    }

    private void initializeUI() {
        setTitle("MDMS - Main Interface");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with search bar and filter icon
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(e -> filterData());
        topPanel.add(searchField);
        topPanel.add(filterButton);

        // User section with clickable hover menu
        JButton userButton = new JButton("Logged In as: " + username);
        JPopupMenu userMenu = new JPopupMenu();
        JMenuItem logoutItem = new JMenuItem("Logout");
        userMenu.add(logoutItem);
        userButton.addActionListener(e -> userMenu.show(userButton, 0, userButton.getHeight()));
        logoutItem.addActionListener(e -> logout());
        topPanel.add(userButton);

        add(topPanel, BorderLayout.NORTH);

        // Table model with non-movable columns
        tableModel = new DefaultTableModel(new String[] { "Title", "Director", "Release Year", "Running Time" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        movieTable = new JTable(tableModel);
        movieTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(movieTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel with Add/Remove buttons
        JPanel bottomPanel = new JPanel();
        JButton addButton = new JButton("Add Movie");
        JButton removeButton = new JButton("Remove Movie");
        addButton.addActionListener(e -> openAddMovieWindow());
        removeButton.addActionListener(e -> removeSelectedMovie());
        bottomPanel.add(addButton);
        bottomPanel.add(removeButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadDataFromDatabase() {
        List<Movie> movies = movieDatabase.getMoviesSortedByTitle();
        for (Movie movie : movies) {
            tableModel.addRow(new Object[] { movie.getTitle(), movie.getDirector(),
                    movie.getReleaseYear(), movie.getRunningTime() });
        }
    }

    private void openAddMovieWindow() {
        JDialog addMovieDialog = new JDialog(this, "Add Movie", ModalityType.APPLICATION_MODAL);
        addMovieDialog.setLayout(new GridLayout(5, 2));
        addMovieDialog.setSize(300, 200);

        JTextField titleField = new JTextField(20);
        JTextField directorField = new JTextField(20);
        JTextField yearField = new JTextField(20);
        JTextField timeField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (titleField.getText().isEmpty() || directorField.getText().isEmpty() ||
                    yearField.getText().isEmpty() || timeField.getText().isEmpty()) {
                // Show warning popup
                JOptionPane.showMessageDialog(addMovieDialog,
                        "All fields must be filled out.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int year = Integer.parseInt(yearField.getText());
                    int time = Integer.parseInt(timeField.getText());

                    // Check if year and time are greater than 0
                    if (year <= 0 || time <= 0) {
                        JOptionPane.showMessageDialog(addMovieDialog,
                                "Release Year and Running Time must be greater than 0.",
                                "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        String title = titleField.getText();
                        String director = directorField.getText();
                        Movie movie = new Movie(title, director, year, time);
                        movieDatabase.addMovie(movie);
                        tableModel.addRow(new Object[] { title, director, year, time });
                        addMovieDialog.dispose();
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(addMovieDialog,
                            "Please enter valid numbers for year and running time.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> addMovieDialog.dispose());

        addMovieDialog.add(new JLabel("Title:"));
        addMovieDialog.add(titleField);
        addMovieDialog.add(new JLabel("Director:"));
        addMovieDialog.add(directorField);
        addMovieDialog.add(new JLabel("Release Year:"));
        addMovieDialog.add(yearField);
        addMovieDialog.add(new JLabel("Running Time:"));
        addMovieDialog.add(timeField);
        addMovieDialog.add(saveButton);
        addMovieDialog.add(cancelButton);

        addMovieDialog.setLocationRelativeTo(this);
        addMovieDialog.setVisible(true);
    }

    private void filterData() {
        // Feature Work
    }

    private void removeSelectedMovie() {
        int row = movieTable.getSelectedRow();
        if (row >= 0) {
            String title = (String) tableModel.getValueAt(row, 0);
            Movie movie = movieDatabase.retrieveMovie(title);
            if (movie != null) {
                movieDatabase.removeMovie(movie);
                tableModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Movie not found in the database.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a movie to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void logout() {
        this.dispose();
        EventQueue.invokeLater(() -> {
            UserInterface loginWindow = new UserInterface(new MovieDatabase());

            loginWindow.setVisible(true);
        });
    }

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        new MainInterface("Username", movieDatabase);
    }
}
