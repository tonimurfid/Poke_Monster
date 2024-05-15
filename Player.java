public class Player {
    private String name;
    private Item item;
    private PlayerHomebase homeBase;

    public Player(String name) {
        this.name = name;
        this.homeBase = new PlayerHomebase();
    }

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PlayerHomebase getHomeBase() {
        return homeBase;
    }

    public void addMonster(Monster monster) {
        homeBase.storeMonster(monster);
    }

    public void removeMonster(Monster monster) {
        homeBase.removeMonster(monster);
    }
}
