public class Earth extends Monster {
    public Earth(String name) {
        super(name);
        this.element = Element.EARTH;
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }

    @Override
    public Monster evolveToAngin() {
        return new Wind(getName());
    }

    @Override
    public Monster evolveToAir(){
        return new Water(getName());
    }
}
