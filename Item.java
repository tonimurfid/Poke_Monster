import java.io.Serializable;

public class Item implements Serializable{
    private String name;
    private int effect;

    public Item(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getEffect() {
        return effect;
    }
}
