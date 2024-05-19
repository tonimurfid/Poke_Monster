public class ItemHeal extends Item {

    private int effect = 15;
    private static int maxUsed = 3;

    public ItemHeal(String nama, String type) {
        super(nama, type);
    }

    public void getEffect(Monster monster) {
        if(maxUsed > 0) {
            monster.setHP(monster.getHP() + effect);
            maxUsed--;
        }else{
            System.out.println("Item ini sudah habis");
        }
    }
}
