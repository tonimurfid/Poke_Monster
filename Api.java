public class Api extends Monster {
    public Api(String name) {
        super(name);
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }
    
    @Override
    public Monster evolveToEs() {
        return new Es(getName());
    }

    @Override
    public Monster evolveToAir(){
        return new Air(getName());
    }
}
