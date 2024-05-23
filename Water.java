public class Water extends Monster {
    // untuk create monster baru
    public Water(String name) {
        super(name);
        this.element = Element.WATER;
        this.atkPower += 5;
        this.specialAtkPower -= 5;
        this.elementAtkPower += 5;
    }
    // untuk evolve
    public Water(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower){
        super(name, level, HP, EP, atkPower, specialAtkPower, elementAtkPower);
        this.element = Element.WATER;
    }
    @Override
    public Monster evolveToFire() {
        return new Fire(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    @Override
    public Monster evolveToEarth(){
        return new Earth(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
}