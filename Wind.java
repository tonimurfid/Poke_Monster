public class Wind extends Monster {
    // untuk create monster baru
    public Wind(String name) {
        super(name);
        this.element = Element.WIND;
        this.atkPower += 5;
        this.specialAtkPower += 10;
        this.elementAtkPower += 0;
    }
    // untuk evolve
    public Wind(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        super(name, level, HP, EP, atkPower, specialAtkPower, elementAtkPower);
        this.element = Element.WIND;
    }
    
    @Override
    public Monster evolveToWater() {
        return new Water(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    @Override
    public Monster evolveToFire(){
        return new Fire(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
    
}
