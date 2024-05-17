public class MonsterBattle implements Battle {
    private Monster playerMonster;
    private Monster enemyMonster;

    public MonsterBattle(Monster playerMonster, Monster enemyMonster) {
        this.playerMonster = playerMonster;
        this.enemyMonster = enemyMonster;
    }

    @Override
    public double basicAttack() {
        double damage = playerMonster.getAtkPower();
        if (damage < 0) damage = 0;
        enemyMonster.setHP(enemyMonster.getHP() - (int) damage);
        return damage;
    }

    @Override
    public double elementAttack() {
        double damage = playerMonster.getElementAtkPower();
        if (damage < 0) damage = 0;
        enemyMonster.setHP(enemyMonster.getHP() - (int) damage);
        return damage;
    }

    @Override
    public double specialAttack() {
        double damage = playerMonster.getSpecialAtkPower();
        if (damage < 0) damage = 0;
        enemyMonster.setHP(enemyMonster.getHP() - (int) damage);
        return damage;
    }

    @Override
    public double useItem(Item item) {
        double effect = item.getEffect();
        playerMonster.setHP(playerMonster.getHP() + (int) effect);
        return effect;
    }

    @Override
    public void flee() {
        // Implementation for fleeing
        System.out.println(playerMonster.getName() + " has fled the battle!");
    }

    @Override
    public void catchMonster() {
        // Implementation for catching a monster
        System.out.println("You have caught the " + enemyMonster.getName() + "!");
    }
}
