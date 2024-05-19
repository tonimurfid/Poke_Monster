public class Water extends Monster {
    public Water(String name) {
        super(name);
        this.element = Element.WATER;
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
    public Monster evolveToTanah(){
        return new Earth(getName());
    }
    public static void main(String[] args) {
        Monster monster1 = new Water("kocak");
        System.out.println(monster1.getElement());
        monster1.setHP(200);
        monster1 = monster1.evolveToApi();
        System.out.println(monster1.getElement());
        System.out.println(monster1.getHP());
    }
}