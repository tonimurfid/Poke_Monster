public class Ice extends Monster {
    public Ice(String name) {
        super(name);
        this.element = Element.ICE;
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }
    
    @Override
    public Monster evolveToApi() {
        return new Fire(getName());
    }

    @Override
    public Monster evolveToAngin(){
        return new Water(getName());
    }
}