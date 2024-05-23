public interface Battle {
    public void basicAttack(Monster target);
    public void elementAttack(Monster target);
    public void specialAttack(Monster target);
    public void useItem(Monster target, Item item);
    public void flee();
}
