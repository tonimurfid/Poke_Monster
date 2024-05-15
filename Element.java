public enum Element {
    ES("es"),
    TANAH("tanah"),
    API("api"),
    ANGIN("angin"),
    AIR("air");

    private final String name;

    Element(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
