import java.util.*;
import java.util.List;

public class Dungeon implements Battle {
    private PlayerHomebase homebase;
    private Monster playerMonster;
    private Monster enemyMonster;

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
        
        System.out.println("Battle found: " + enemyMonster.getName()); 

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
    public void useItem(Item item) {
        
    }

    @Override
    public void flee() {
        System.out.println("Fleeing from battle...");
    }

    @Override
    public Monster catchMonster() {
        System.out.println("You caught a " + enemyMonster.getName() + " !");
        return enemyMonster;
    }
}
