public class Angin extends Monster {
    public Angin(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        super(name, Element.ANGIN);
        this.level = level;
        this.HP = HP;
        this.EP = EP;
        this.atkPower = atkPower;
        this.specialAtkPower = specialAtkPower;
        this.elementAtkPower = elementAtkPower;
    }
    
    public Monster evolveToEs() {
        return new Es(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    public Monster evolveToTanah(){
        return new Tanah(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
}
