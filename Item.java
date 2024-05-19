import java.io.Serializable;

public class Item implements Serializable{
    private String name;
    private int effect;
    
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
