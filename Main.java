import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Create a sample player and monsters for demonstration
        Scanner input = new Scanner(System.in);
        Player player = new Player("Ash");
        Monster waterMonster = new Water("Aquarion");
        Monster fireMonster = new Fire("Blazetalon");
        Monster earthMonster = new Earth("Terraquake");
        Monster windMonster = new Wind("Galehawk");
        Monster iceMonster = new Ice("Frosthorn");
        System.out.println("""
                Welcome to the Poke-Mon game!
                choose your pokemon:
                1. Ice
                2. Fire
                3. Earth
                4. Water
                5. Wind
                """);
        System.out.print("Choose 3 Monsters: ");
        for(int i = 0; i < 3 ; i++){
            switch (input.nextInt()) {
                case 1:
                    player.addMonster(iceMonster);
                    break;
                case 2:
                    player.addMonster(fireMonster);
                    break;
                case 3:
                    player.addMonster(earthMonster);
                    break;
                case 4:
                    player.addMonster(waterMonster);
                    break;
                case 5:
                    player.addMonster(windMonster);
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
        saveGame(player,"SaveGame/game_save1.txt");
        Player loadPlayer = null;
        try{
            loadPlayer = loadGame("SaveGame/game_save1.txt");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(loadPlayer.getName());
        loadPlayer.getHomeBase().showMonsters();
        System.out.println("-".repeat(50));
        Dungeon dungeon = new Dungeon(loadPlayer.getHomeBase());
        dungeon.explore();
    }

    public static void saveGame(Player player, String path) {
        try {
            // Membuka file output stream
            FileOutputStream fileOut = new FileOutputStream(path);
            // Membuat object output stream
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            // Menyimpan objek ke dalam file
            objectOut.writeObject(player);
            // Menutup output stream
            objectOut.close();
            // Menutup file stream
            fileOut.close();
            System.out.println("Objek berhasil disimpan ke dalam file " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Player loadGame(String path) {
        Player player = null;
        try {
            // Membuka file input stream
            FileInputStream fileIn = new FileInputStream(path);
            // Membuat object input stream
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            // Memuat objek dari file
            player = (Player) objectIn.readObject();
            // Menutup input stream
            objectIn.close();
            // Menutup file stream
            fileIn.close();
            System.out.println("Objek berhasil dimuat dari file " + path);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return player;
    }
}
