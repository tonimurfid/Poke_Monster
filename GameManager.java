import java.io.*;
import java.util.*;
public class GameManager {
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
