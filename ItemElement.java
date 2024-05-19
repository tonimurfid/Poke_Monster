public class ItemElement extends Item {

    private int effect = 20;
    private static int maxUsed = 2;

    public ItemElement(String nama, String type) {
        super(nama, type);
    }
    public void getEffect(Monster monster) {
        if(maxUsed > 0) {
            monster.setHP(monster.getHP() - effect);
            maxUsed--;
        }else{
            System.out.println("Item ini sudah habis");
        }
    }
}
