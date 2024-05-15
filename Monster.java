public abstract class Monster {
    private String name;
    private int level;
    private int HP;
    private int EP;
    private int atkPower;
    private int specialAtkPower;
    private int elementAtkPower;
    private int defPower;
    private Element element;

    public Monster(String name, Element element) {
        this.name = name;
        this.level = 1;
        this.HP = 100;
        this.EP = 50;
        this.atkPower = 20;
        this.specialAtkPower = 30;
        this.elementAtkPower = 25;
        this.defPower = 15;
        this.element = element;
    }
    public int setHP(int HP) {
        this.HP = HP;
        return HP;
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

    public int getDefPower() {
        return defPower;
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
        this.defPower += 3;
    }

    public void evolve() {
        // Evolve logic
    }

    public void heal() {
        this.HP = 100 + (level * 20);  // Restore HP based on level
    }
}
