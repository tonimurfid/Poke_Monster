import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        // Create a sample player and monsters for demonstration
        Player player = new Player("Ash");
        Monster monster1 = new Air("kocak",Element.AIR);
        Monster monster2 = new Air();

        player.addMonster(monster1);
        player.addMonster(monster2);

        players.add(player);

        saveGame("game_save.txt");
        loadGame("game_save.txt");
    }

    public static void loadGame(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            players = (ArrayList<Player>) ois.readObject();
            System.out.println("Game Loaded Successfully");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
    }

    public static void saveGame(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(players);
            System.out.println("Game Saved Successfully");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }
}
