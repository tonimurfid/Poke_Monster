public interface Battle {
    public void basicAttack(Monster user, Monster target);
    public void elementAttack(Monster user, Monster target);
    public void specialAttack(Monster user, Monster target);
    public void useItem(Item item);
    public void flee();
}
