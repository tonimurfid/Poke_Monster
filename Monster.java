import java.io.Serializable;

public abstract class Monster implements Serializable{
    protected String name;
    protected int level;
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
        this.HP = 100;
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
    public void setName(String name){
        this.name = name;
    }
    public void setHP(int HP) {
        this.HP = Math.min(HP, 100);
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
        this.HP += 20;
        this.EP += 10;
        this.atkPower += 5;
        this.specialAtkPower += 5;
        this.elementAtkPower += 5;
    }

    public void heal() {
        this.HP = Math.min(100 + (level * 20), 400); // misal 400 adalah max hp
    }
    public Monster evolveToApi() {
        return null;
    }
    public Monster evolveToAngin() {
        return null;
    }
    public Monster evolveToTanah() {
        return null;
    }
    public Monster evolveToAir() {
        return null;
    }
    public Monster evolveToEs() {
        return null;
    }
}
