import java.util.*;
import java.util.List;

public class Dungeon implements Battle {
    private PlayerHomebase homebase;
    private Monster playerMonster;
    private Monster enemyMonster;
    private Scanner input = new Scanner(System.in);
    private Item item ;
    private List<Item> itemList = new ArrayList<>();

    private Monster [] enemy = {
            new Water("Aquarion"),
            new Fire("Blazetalon"),
            new Earth("Terraquake"),
            new Wind("Galehawk"),
            new Ice("Frosthorn")
    };

    public Dungeon(PlayerHomebase homebase) {
        this.homebase = homebase;
    }
    private List<Monster> ChoosenMonster() {
        List<Monster> choosen = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("list monster");
        homebase.showMonsters();
        for (int i = 0; i < 3; i++) {
            System.out.println("Choose monster " + (i+1));
            int choice = input.nextInt();
            if(choice == 0) {
                break;
            }else if(choice > 0 && choice <= homebase.petMonsters.size()) {
                Monster pilihan = homebase.petMonsters.get(choice);
                choosen.add(pilihan);
                System.out.println(pilihan.getName() + " added to your team");
            }else{
                System.out.println("Monster not found");
                i--;
            }
        }
        return choosen;
    }

    public void explore() {
        // Explore dungeon logic
    
        System.out.println("Exploring dungeon...");
        List<Monster> choosen = ChoosenMonster();
        System.out.println("Your team: ");
        for (Monster monster : choosen) {
            System.out.println(monster.getName());
        }
        
        // choose enemy monster
        Random random = new Random();
        enemyMonster = enemy[random.nextInt(5)];
        System.out.println("Battle found: " + enemyMonster.getName()); 
        System.out.println("Choose your Poke-Monster: ");
        int choice = input.nextInt();input.nextLine();
        playerMonster = choosen.get(choice);
        System.out.println("Your Poke-Monster: " + playerMonster.getName());
        System.out.println("Battle started...");
        System.out.println("""
                1. Basic Attack
                2. Element Attack
                3. Special Attack
                4. Use Item
                5. Flee
                """);

        // battle logic
        while(playerMonster.getHP() > 0 && enemyMonster.getHP() > 0) {
            System.out.println("Choose action: ");
            int action = input.nextInt();input.nextLine();
            if(action == 0) {
                break;
            }else if(action == 1) {
                basicAttack(playerMonster, enemyMonster);
            }else if(action == 2) {
                elementAttack(playerMonster, enemyMonster);
            }else if(action == 3) {
                specialAttack(playerMonster, enemyMonster);
            }else if(action == 4) {
                itemList.add(new ItemHeal("Healer", "Heal"));
                useItem(playerMonster, item);
                itemList.add(new ItemElement("Elixir", "Element"));
                System.out.println("""
                        Choose item:
                        1. Element
                        2. Heal
                        """);
                int itemChoice = input.nextInt();input.nextLine();
                item = itemList.get(itemChoice);
                useItem(playerMonster, item);
            }else if(action == 5) {
                flee();
            }
        }
        System.out.println("Enter 0 to exit");
    }

    public void exit() {
        System.out.println("You are exiting the dungeon...");
    }

    @Override
    public void basicAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getAtkPower());
    }

    @Override
    public void elementAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getElementAtkPower());
    }

    @Override
    public void specialAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getSpecialAtkPower());
    }

    @Override
    public void useItem(Monster user, Item item) {
        item.getEffect(user);
        System.out.println("Item used: " + item.getName());
    }

    @Override
    public void flee() {
        System.out.println("Fleeing from battle...");
    }
}
