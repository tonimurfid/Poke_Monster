public class Dungeon {
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
}
