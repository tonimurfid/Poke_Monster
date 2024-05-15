import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonSelection extends JFrame {
    private JPanel mainPanel;
    private JLabel imageLabel;

    public PokemonSelection() {
        // Set up the frame
        setTitle("Choose Your Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        mainPanel = new JPanel(new BorderLayout());

        // Image label to display the selected Pokémon
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add buttons for each Pokémon
        addButton(buttonPanel, "Pikachu", "pikachu.png");
        addButton(buttonPanel, "Charmander", "charmander.png");
        addButton(buttonPanel, "Bulbasaur", "bulbasaur.png");

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addButton(JPanel panel, String name, String imagePath) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load and display the selected Pokémon image
                ImageIcon icon = new ImageIcon(imagePath);
                imageLabel.setIcon(icon);
            }
        });
        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PokemonSelection().setVisible(true);
            }
        });
    }
}
