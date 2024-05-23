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
    public void enterHomebase() {
        Scanner input = new Scanner(System.in);
        copyMonsters = new ArrayList<>(petMonsters);
        while (true) {
                System.out.println("""
                        Welcome to your homebase!
                        1. Heal
                        2. Level Up
                        3. Evolve
                        4. Shop
                        5. Explore
                        """);
                
                switch (input.nextInt()) {
                    case 1:
                        for(Monster m : petMonsters) {
                            healing();
                        }
                        break;
                    case 2:
                        System.out.println("Choose monster to level up");
                        showMonsters();
                        switch (input.nextInt()) {
                            case 1:
                                levelUp(petMonsters.get(0));
                                break;
                            case 2:
                                levelUp(petMonsters.get(1));
                                break;
                            case 3:
                                levelUp(petMonsters.get(2));
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Choose monster to evolve");
                        showMonsters();
                        switch (input.nextInt()) {
                            case 1:
                                evolve(petMonsters.get(0));
                                break;
                            case 2:
                                evolve(petMonsters.get(1));
                                break;
                            case 3:
                                evolve(petMonsters.get(2));
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                        break;
                    case 4:
                        shopItem();
                        break;
                    case 5:
                        exploreDungeon();
                        break;
                    default:
                        break;
                }
            }
    }
    public void showMonsters() {
        System.out.println("Your monsters:");
        for (Monster monster : petMonsters) {
            System.out.println(monster.getName());
            System.out.println(monster.getElement());
        }
    }

    public void storeMonster(Monster monster) {
        petMonsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        petMonsters.remove(monster);
    }

    // public void copy() {
    //     for(Monster m : petMonsters) {
    //         copyMonsters.add(m);
    //     }
    // }

    public void healing() {
        for (int i = 0; i < petMonsters.size(); i++) {
            Monster petMonster = petMonsters.get(i);
            Monster copyMonster = copyMonsters.get(i);
            petMonster.setHP(copyMonster.getHP());
            petMonster.setEP(copyMonster.getEP());
        }
    }
    

    public void levelUp(Monster monster) {
        if(monster.getEP() >= 100) {
            monster.setEP(monster.getEP() - 100);
            monster.levelUp();
            System.out.println(monster.getName() + " level up!");
        }else {
            System.out.println("Not enough EP");
        }
    }

    public void evolve(Monster monster) {
        Scanner input = new Scanner(System.in);
        int index = petMonsters.indexOf(monster);
        Monster evolvedMonster = monster;  // To keep track of the evolved monster
        // System.out.println(evolvedMonster.getName() + " evolve to ?");
        // System.out.println(evolvedMonster.getElement());
        switch (monster.getElement()) {
            case EARTH:
                System.out.println("""
                        1. evolve to fire
                        2. evolve to ice
                        """);
                switch (input.nextInt()) {
                    case 1:
                        evolvedMonster = monster.evolveToFire();
                        break;
                    case 2:
                        evolvedMonster = monster.evolveToIce();
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }
                break;
            case FIRE:
                System.out.println("""
                        1. evolve to wind
                        2. evolve to earth
                        """);
                switch (input.nextInt()) {
                    case 1:
                        evolvedMonster = monster.evolveToWind();
                        break;
                    case 2:
                        evolvedMonster = monster.evolveToEarth();
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }
                break;
            case WIND:
                System.out.println("""
                        1. evolve to water
                        2. evolve to fire
                        """);
                switch (input.nextInt()) {
                    case 1:
                        evolvedMonster = monster.evolveToWater();
                        break;
                    case 2:
                        evolvedMonster = monster.evolveToFire();
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }
                break;
            case WATER:
                System.out.println("""
                        1. evolve to ice
                        2. evolve to wind
                        """);
                switch (input.nextInt()) {
                    case 1:
                        evolvedMonster = monster.evolveToIce();
                        break;
                    case 2:
                        evolvedMonster = monster.evolveToWind();
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }
                break;
            case ICE:
                System.out.println("""
                        1. evolve to earth
                        2. evolve to water
                        """);
                switch (input.nextInt()) {
                    case 1:
                        evolvedMonster = monster.evolveToEarth();
                        break;
                    case 2:
                        evolvedMonster = monster.evolveToWater();
                        break;
                    default:
                        System.out.println("Invalid input");
                        return;
                }
                break;
            default:
                System.out.println("Invalid input");
                return;
        }
        petMonsters.set(index, evolvedMonster);
    
        System.out.println("Evolved to: " + evolvedMonster.getElement());
    }
    

    public void exploreDungeon() {
        Dungeon dungeon = new Dungeon(this, itemList);
        dungeon.explore();
    }
    
    public Item shopItem() {
        Scanner input = new Scanner(System.in);
        int EP = 0;
        Monster monster = null;
        showMonsters();
        switch (input.nextInt()) {
            case 1:
                monster = petMonsters.get(0);
                break;
            case 2:
                monster = petMonsters.get(1);
                break;
            case 3:
                monster = petMonsters.get(2);
                break;
            default:
            System.out.println("Invalid input");
                break;
        }
        input.nextLine();
        System.out.println("""
                Shop :
                0. Exit
                1. Healing Potion (+10 HP) 10 EP
                2. Elixir (+20 EP) 20 EP
                """);
        switch (input.nextInt()) {
            case 0:
                break;
            case 1:
                if(itemList.size() < 3) {
                    if(monster.getEP() >= 10) {
                        monster.setEP(monster.getEP() - 10);
                    itemList.add(new ItemHeal("Healing Potion", "Heal"));
                    }
                }
                break;
            case 2:
                if(itemList.size() < 3) {
                    if(monster.getEP() >= 20) {
                        monster.setEP(monster.getEP() - 20);
                        itemList.add(new ItemHeal("Elixir", "Elemental"));
                    }
                }
                break;
            default:
            System.out.println("Invalid input");
                break;
        }
        return null;
    }
}
