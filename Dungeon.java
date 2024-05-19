public class Dungeon implements Battle {
    private Monster playerMonster;
    private Monster enemyMonster;

    public Dungeon(Monster playerMonster, Monster enemyMonster) {
        this.playerMonster = playerMonster;
        this.enemyMonster = enemyMonster;
    }

    public void explore() {
        // Explore dungeon logic
        System.out.println("Exploring dungeon...");
    }

    public void exit() {
        System.out.println("You are exiting the dungeon...");
    }

    @Override
    public void basicAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getAtkPower());
    }

    @Override
    public void elementAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getElementAtkPower());
    }

    @Override
    public void specialAttack(Monster user, Monster target) {
        target.setHP(target.getHP() - user.getSpecialAtkPower());
    }

    @Override
    public void useItem(Item item) {
        
    }

    @Override
    public void flee() {
        
        
    }

    @Override
    public void catchMonster(Monster target) {
        System.out.println("You caught a " + target.getName() + " !");
    }
}
