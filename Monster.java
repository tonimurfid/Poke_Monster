public abstract class Monster {
    protected String name;
    protected int level;
    protected int HP;
    protected int EP;
    protected int atkPower;
    protected int specialAtkPower;
    protected int elementAtkPower;
    protected Element element;

    public Monster(String name, Element element) {
        this.name = name;
        this.level = 1;
        this.HP = 100;
        this.EP = 50;
        this.atkPower = 20;
        this.specialAtkPower = 30;
        this.elementAtkPower = 25;
        this.element = element;
    }
    public void setName(String name){
        this.name = name;
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
}
