public class Air extends Monster {
    public Air(String name, Element element) {
        super(name, element);
        // this.level = level;
        // this.HP = HP;
        // this.EP = EP;
        // this.atkPower = atkPower;
        // this.specialAtkPower = specialAtkPower;
        // this.elementAtkPower = elementAtkPower;
    }
    @Override
    public Monster evolveToApi() {
        return new Api(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }

    public Monster evolveToTanah(){
        return new Tanah(getName(), getLevel(), getHP(), getEP(), getAtkPower(), getSpecialAtkPower(), getElementAtkPower());
    }
    public static void main(String[] args) {
        Monster monster1 = new Air("kocak",Element.AIR);
        System.out.println(monster1.getElement());
        monster1.setHP(200);
        monster1 = monster1.evolveToApi();
        System.out.println(monster1.getElement());
        System.out.println(monster1.getHP());
    }
}