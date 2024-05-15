import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonSelection extends JFrame {
    private JPanel mainPanel;
    private JLabel imageLabel;
    private static final int IMG_WIDTH = 200; // Lebar gambar yang diinginkan
    private static final int IMG_HEIGHT = 200; // Tinggi gambar yang diinginkan

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
        addButton(buttonPanel, "Es", "Monster_Pict/Monster_Es1_rbg.png");
        addButton(buttonPanel, "Api", "Monster_Pict/Monster_Api1_rbg.png");
        addButton(buttonPanel, "Tanah", "Monster_Pict/Monster_Tanah1_rbg.png");
        addButton(buttonPanel, "Air", "Monster_Pict/Monster_Air1_rbg.png");
        addButton(buttonPanel, "Angin", "Monster_Pict/Monster_Angin1_rbg.png");

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addButton(JPanel panel, String name, String imagePath) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load and resize the selected Pokémon image
                ImageIcon icon = new ImageIcon(imagePath);
                Image image = icon.getImage().getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(image));
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
