public class Wind extends Monster {
    public Wind(String name) {
        super(name);
        this.element = Element.WIND;
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }
    
    @Override
    public Monster evolveToEs() {
        return new Ice(getName());
    }

    @Override
    public Monster evolveToTanah(){
        return new Earth(getName());
    }
}
