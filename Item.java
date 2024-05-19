import java.io.Serializable;

public class Item implements Serializable{
    private int effect = 20;
    private static int maxUsed = 4;

    public void getDamagePotion(Monster monster) {
        if(maxUsed > 0) {
            monster.setHP(monster.getHP() + effect);
            maxUsed--;
        }else{
            System.out.println("Item ini sudah habis");
        }
    }
    
}
