public interface Battle {
    double basicAttack();
    double elementAttack();
    double specialAttack();
    double useItem(Item item);
    void flee();
    void catchMonster();
}
