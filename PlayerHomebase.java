import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerHomebase implements Serializable {
    List<Monster> petMonsters;
    List<Monster> copyMonsters;
    List<Item> itemList = new ArrayList<>();

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

    public void copy() {
        for(Monster m : petMonsters) {
            copyMonsters.add(m);
        }
    }

    public void healing(Monster monster) {
        monster.heal();
    }

    public void levelUp(Monster monster) {
        if(monster.getEP() >= 100) {
            monster.levelUp();
            System.out.println(monster.getName() + " level up!");
        }
    }

    public void evolve(Monster monster) {
        monster.evolveToAir();
    }

    public void exploreDungeon() {
        Dungeon dungeon = new Dungeon(this);
        dungeon.explore();
    }

    public Item shopItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Shop :
                0. Exit
                1. Healing Potion (+10 HP)
                2. Elixir (+20 EP)
                """);
        switch (input.nextInt()) {
            case 0:
                break;
            case 1:
                if(itemList.size() < 3) {
                    itemList.add(new ItemHeal("Healing Potion", "Heal"));
                }
                break;
            case 2:
                if(itemList.size() < 3) {
                    itemList.add(new ItemHeal("Elixir", "Elemental"));
                }
                break;
            default:
                break;
        }
        return null;
    }
}
