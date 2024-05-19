import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerHomebase implements Serializable {
    private List<Monster> petMonsters;

    public PlayerHomebase() {
        this.petMonsters = new ArrayList<>();
    }

    public List<Monster> listMonsters() {
        return petMonsters;
    }
    public void showMonsters() {
        System.out.println("Your monsters:");
        for (Monster monster : petMonsters) {
            System.out.println(monster.getName());
        }
    }

    public void storeMonster(Monster monster) {
        petMonsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        petMonsters.remove(monster);
    }

    public void pickMonster(Monster monster) {
        // Select monster for battle
    }

    public void healing(Monster monster) {
        monster.heal();
    }

    public void levelUp(Monster monster) {
        monster.levelUp();
    }

    public void evolve(Monster monster) {
        monster.evolveToAir();
    }

    public void exploreDungeon() {
        // Implementation for exploring dungeon
    }
}
