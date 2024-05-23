public class ItemElement extends Item {

    private int effect = 20;
    private static int maxUsed = 2;

    public ItemElement(String nama, String type) {
        super(nama, type);
    }

    @Override
    public void getEffect(Monster user, Monster target, Element elementType) {
        int elementAttackPower = user.getElementAtkPower();
    switch (elementType) {
        case EARTH:
            if(target instanceof Water){
                elementAttackPower = (int) (elementAttackPower * 1.5);
            }
            break;
        case WATER:
            if(target instanceof Fire){
                elementAttackPower = (int) (elementAttackPower * 1.5);
            }
            break;
        case FIRE:
            if(target instanceof Ice){
                elementAttackPower = (int) (elementAttackPower * 1.5);
            }
            break;
        case ICE:
            if(target instanceof Wind){
                elementAttackPower = (int) (elementAttackPower * 1.5);
            }
            break;
        case WIND:
            if(target instanceof Earth){
                elementAttackPower = (int) (elementAttackPower * 1.5);
            }
            break;
        default:
            break;
    }
    target.setHP(target.getHP() - elementAttackPower);
    System.out.println(user.getName() + " used Item Element on " + target.getName() + " with " + elementAttackPower + " damage");
    System.out.println(target.getName() + " has " + target.getHP() + " HP left");
    }
}
