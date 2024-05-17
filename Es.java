public class Es extends Monster {
    public Es(String name) {
        super(name);
        this.element = Element.ES;
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }
    
    @Override
    public Monster evolveToApi() {
        return new Api(getName());
    }

    @Override
    public Monster evolveToAngin(){
        return new Angin(getName());
    }
}