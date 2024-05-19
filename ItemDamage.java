public class ItemDamage extends Item {
    private int effect = 20;
    private int maxUsed = 2;
    public ItemDamage(String name) {
        super(name);
    }
    public void getDamagePotion(Monster monster) {
        if(maxUsed > 0) {
            monster.setHP(monster.getHP() - effect);
            maxUsed--;
        }else{
            System.out.println("Item ini sudah habis");
        }
    }
}
