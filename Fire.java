public class Fire extends Monster {
    public Fire(String name) {
        super(name);
        this.element = Element.FIRE;
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
    public Monster evolveToAir(){
        return new Water(getName());
    }
}
