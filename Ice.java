public class Ice extends Monster {
    // untuk create monster baru
    public Ice(String name) {
        super(name);
        this.element = Element.ICE;
        this.atkPower += 5;
        this.specialAtkPower += 3;
        this.elementAtkPower += 15;
    }
    // untuk evolve
    public Ice(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        super(name, level, HP, EP, atkPower, specialAtkPower, elementAtkPower);
        this.element = Element.ICE;
    }
    
    @Override
    public Monster evolveToEarth() {
        return new Earth(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    @Override
    public Monster evolveToWater(){
        return new Water(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
}