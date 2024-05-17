public class Angin extends Monster {
    public Angin(String name) {
        super(name);
        this.element = Element.ANGIN;
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
    public Monster evolveToTanah(){
        return new Tanah(getName());
    }
}
