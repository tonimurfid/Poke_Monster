import java.io.Serializable;

public abstract class Item implements Serializable{

    private String name;
    private String type;
    private int effect;
    private static int maxUsed;

    public Item(String nama, String type) {
        this.name = nama;
        this.type = type;
    }
    public void getEffect() {}
}
