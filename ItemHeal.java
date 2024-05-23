public class ItemHeal extends Item {

    private int effect = 15;
    private static int maxUsed = 3;

    public ItemHeal(String nama, String type) {
        super(nama, type);
    }
    @Override
    public void getEffect(Monster monster, Monster target) {
        if(maxUsed > 0) {
            monster.setHP(monster.getHP() + effect);
            System.out.println("Heal " + effect + " HP to " + monster.getName());
            maxUsed--;
        }else{
            System.out.println("Item ini sudah habis");
        }
    }
}
