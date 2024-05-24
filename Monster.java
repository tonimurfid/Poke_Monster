import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public abstract class Monster implements Battle, Serializable{
    protected String name;
    protected int level;
    protected int maxEvolve = 1;
    protected int HP;
    protected int EP;
    protected int atkPower;
    protected int specialAtkPower;
    protected int elementAtkPower;
    protected Element element;

    // CREATE MONSTER
    public Monster(String name) {
        this.name = name;
        this.level = 1;
        this.HP = 120;
        this.EP = 50;
        this.atkPower = 15;
        this.specialAtkPower = 20;
        this.elementAtkPower = 30;
    }
    // EVOLVE MONSTER
    public Monster(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.EP = EP;
        this.atkPower = atkPower;
        this.specialAtkPower = specialAtkPower;
        this.elementAtkPower = elementAtkPower;
    }
    public void useMaxEvolve() {
        this.maxEvolve--;
    }
    public void addMaxEvolve() {
        this.maxEvolve++;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setHP(int HP) {
        int maxHP = 100 + (this.level * 20);
        this.HP = Math.min(HP, maxHP);
        this.HP = Math.max(HP, 0);
    }
    public void setLevel(int level) {
        this.level = Math.min(level, 99);
    }

    public void setElementAtkPower(int elementAtkPower) {
        this.elementAtkPower = elementAtkPower;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxEvolve() {
        return maxEvolve;
    }

    public int getHP() {
        return HP;
    }

    public int getEP() {
        return EP;
    }

    public int getAtkPower() {
        return atkPower;
    }

    public int getSpecialAtkPower() {
        return specialAtkPower;
    }

    public int getElementAtkPower() {
        return elementAtkPower;
    }

    public Element getElement() {
        return element;
    }

    public void levelUp() {
        this.level++;
        this.HP = 100 + (this.level * 20);
        this.EP += 10;
        this.maxEvolve = 1;
        this.atkPower += 7;
        this.specialAtkPower += 5;
        this.elementAtkPower += 5;
    }
    public Monster evolveToFire() {
        return null;
    }
    public Monster evolveToWind() {
        return null;
    }
    public Monster evolveToEarth() {
        return null;
    }
    public Monster evolveToWater() {
        return null;
    }
    public Monster evolveToIce() {
        return null;
    }
    public void setEP(int EP) {
        this.EP = EP;
    }
    public void heal(){
        this.HP = 100 + (this.level * 20);
        System.out.println(this.getName() + " has been healed");
    }
    @Override
    public void basicAttack(Monster target) {
        target.setHP(target.getHP() - this.getAtkPower());
        System.out.println(this.getName() + " used Basic Attack on " + target.getName() + " with " + this.getAtkPower() + " damage");
        System.out.println(target.getName() + " has " + target.getHP() + " HP left");
    }

    @Override
    public void specialAttack(Monster target) {
        Random random = new Random();
        int chance = random.nextInt(5)+1;
        if(chance > 3) {
            target.setHP(target.getHP() - this.getSpecialAtkPower());
            this.setHP(((int)this.getHP()*90/100));
            System.out.println(this.getName() + " used Special Attack on " + target.getName() + " with " + this.getSpecialAtkPower() + " damage");
            System.out.println(target.getName() + " has " + target.getHP() + " HP left");
        }else{
            System.out.println(this.getName() + " failed to use Special Attack on " + target.getName());
        }
    }
    @Override
    public void elementAttack(Monster target) {
        int elementAttackPower = this.getElementAtkPower();
        switch (this.getElement()) {
            case EARTH:
                if(target instanceof Water){
                    elementAttackPower = (int) (elementAttackPower * 1.2);
                }
                break;
            case WATER:
                if(target instanceof Fire){
                    elementAttackPower = (int) (elementAttackPower * 1.2);
                }
                break;
            case FIRE:
                if(target instanceof Ice){
                    elementAttackPower = (int) (elementAttackPower * 1.2);
                }
                break;
            case ICE:
                if(target instanceof Wind){
                    elementAttackPower = (int) (elementAttackPower * 1.2);
                }
                break;
            case WIND:
                if(target instanceof Earth){
                    elementAttackPower = (int) (elementAttackPower * 1.2);
                }
                break;
            default:
                break;
        }
        target.setHP(target.getHP() - elementAttackPower);
        System.out.println(this.getName() + " used Element Attack on " + target.getName() + " with " + elementAttackPower + " damage");
        System.out.println(target.getName() + " has " + target.getHP() + " HP left");
    }
    @Override
    public void useItem(Monster target, Item item) {
        if(item instanceof ItemElement) {
            System.out.println("""
                    choose element to use:
                    1. Earth
                    2. Water
                    3. Fire
                    4. Ice
                    5. Wind
                    """);
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            Element element = null;
            switch (choice) {
                case 1:
                    element = Element.EARTH;
                    break;
                case 2:
                    element = Element.WATER;
                    break;
                case 3:
                    element = Element.FIRE;
                    break;
                case 4:
                    element = Element.ICE;
                    break;
                case 5:
                    element = Element.WIND;
                    break;
                    
                }
            item.getEffect(this, target, element);
            System.out.println("Item used: " + item.getName());
        }else{
            item.getEffect(this, target);
            System.out.println("Item used: " + item.getName());
        }
    }

    @Override
    public void flee() {
        Random random = new Random();
        int chance = random.nextInt(5)+1;
        if(chance > 3) {
            System.out.println("Fleeing from battle...");
            return;
        }else{
            System.out.println("Failed to flee from battle...");
        }
    }
}
