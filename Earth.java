public class Earth extends Monster {
    // untuk create monster baru
    public Earth(String name) {
        super(name);
        this.element = Element.EARTH;
        this.atkPower += 5;
        this.specialAtkPower += 10;
        this.elementAtkPower += 0;
    }
    // untuk evolve
    public Earth(String name, int level, int HP, int EP, int atkPower, int specialAtkPower, int elementAtkPower) {
        super(name, level, HP, EP, atkPower, specialAtkPower, elementAtkPower);
        this.element = Element.EARTH;
    }

    @Override
    public Monster evolveToAngin() {
        return new Wind(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    @Override
    public Monster evolveToAir(){
        return new Water(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
    public static void main(String[] args) {
        Monster monster1 = new Earth("kocak");
        System.out.println(monster1.getElement());
        monster1.setHP(200);
        monster1 = monster1.evolveToAir();
        System.out.println(monster1.getElement());
        System.out.println(monster1.getHP());
        System.out.println(monster1.getAtkPower());
        System.out.println(monster1.getSpecialAtkPower());
    }
}
