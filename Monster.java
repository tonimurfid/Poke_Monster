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
    public void setName(String name){
        this.name = name;
    }
    public void setHP(int HP) {
        int maxHP = 100 + (this.level * 20);
        this.HP = Math.min(HP, 100);
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
        this.HP += 10;
        this.EP += 5;
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
}
