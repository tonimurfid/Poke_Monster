public class Tanah extends Monster {
    public Tanah(String name) {
        super(name);
        this.element = Element.AIR;
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }

    @Override
    public Monster evolveToAngin() {
        return new Angin(getName());
    }

    @Override
    public Monster evolveToAir(){
        return new Air(getName());
    }
}
