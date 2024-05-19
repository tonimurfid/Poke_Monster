public enum Element {
    ICE("ice"),
    EARTH("earth"),
    FIRE("fire"),
    WIND("wind"),
    WATER("water");

    private final String name;

    Element(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
