public class Ice extends Monster {
    // untuk create monster baru
    public Ice(String name) {
        super(name);
        this.element = Element.EARTH;
        this.atkPower += 5;
        this.specialAtkPower += 10;
        this.elementAtkPower += 0;
    }
    // untuk evolve
    public Ice(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        super(name, level, HP, EP, atkPower, specialAtkPower, elementAtkPower);
        this.element = Element.EARTH;
    }
    
    @Override
    public Monster evolveToFire() {
        return new Fire(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    @Override
    public Monster evolveToWind(){
        return new Water(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
}