import java.util.*;
import java.util.List;

public class Dungeon{
    private PlayerHomebase homebase;
    private Monster playerMonster;
    private Monster enemyMonster;
    private Scanner input = new Scanner(System.in);
    private Item item ;
    private List<Item> itemList;
    private List<Item> itemEnemy = new ArrayList<>();
    Random random = new Random();

    private Monster [] enemy = {
            new Water("Waterion"),
            new Fire("Charid"),
            new Earth("Terrabyte"),
            new Wind("Flyer"),
            new Ice("Iceberg")
    };

    public Dungeon(PlayerHomebase homebase, List<Item> itemList) {
        this.homebase = homebase;
        this.itemList = itemList;
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
                Monster pilihan = homebase.petMonsters.get(choice-1);
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
        while(true){

            // choose your team
            System.out.println("Exploring dungeon...");
            List<Monster> choosen = ChoosenMonster();
            System.out.println("Your team: ");
            for (Monster monster : choosen) {
                System.out.println(monster.getName());
            }
            
            // choose enemy monster
            enemyMonster = enemy[random.nextInt(5)];
            System.out.println("Battle found: " + enemyMonster.getName()); 
            System.out.println("Choose your Poke-Monster: ");
            int choice = input.nextInt();input.nextLine();
            playerMonster = choosen.get(choice-1);
            System.out.println("Your Poke-Monster: " + playerMonster.getName());
            System.out.println("Battle started...");
            
            // battle logic
            while(playerMonster.getHP() > 0 && enemyMonster.getHP() > 0) {
                System.out.println("""
                        1. Basic Attack
                        2. Element Attack
                        3. Special Attack
                        4. Use Item
                        5. Flee
                        """);
                System.out.println("Choose action: ");
                int action = input.nextInt();input.nextLine();
                if(action == 0) {
                    break;
                }else if(action == 1) {
                    playerMonster.basicAttack(enemyMonster);
                }else if(action == 2) {
                    playerMonster.elementAttack(enemyMonster);
                }else if(action == 3) {
                    playerMonster.specialAttack(enemyMonster);
                }else if(action == 4) {
                    int count = 1;
                    for(Item i : itemList) {
                        System.out.println("Item " + count++);
                        i.printItem();
                    }
                    int itemChoice = input.nextInt();
                    item = itemList.get(itemChoice-1);
                    itemList.remove(itemChoice-1);
                    playerMonster.useItem(enemyMonster,item);
                }else if(action == 5) {
                    playerMonster.flee();
                }
                if (playerMonster.getHP() > 0 && enemyMonster.getHP() > 0) {
                    int enemyAction = random.nextInt(3)+1;
                    if(enemyAction == 1) {
                        enemyMonster.basicAttack(playerMonster);
                    }else if(enemyAction == 2) {
                        enemyMonster.elementAttack(playerMonster);
                    }else if(enemyAction == 3) {
                        enemyMonster.specialAttack(playerMonster);
                    }
                }
            }
    
            if(playerMonster.getHP() <= 0) {
                System.out.println("YOU LOSE");
            }else if(enemyMonster.getHP() <= 0) {
                playerMonster.setEP(playerMonster.getEP() + 50);
                System.out.println("YOU WIN");
            }
            System.out.println("""
                1. Explore
                2. Homebase
                3. Exit
                """);

            int choice2 = input.nextInt();input.nextLine();
            switch (choice2) {
                case 1:
                    break;
                case 2:
                    homebase.enterHomebase();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
