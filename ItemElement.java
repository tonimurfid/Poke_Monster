public class ItemElement extends Item {

    private int effect = 20;
    private static int maxUsed = 2;

    public ItemElement(String nama, String type) {
        super(nama, type);
    }
    @Override
    public void getEffect(Monster user, Monster target, Element elementType) {
    switch (elementType) {
        case EARTH:
            if(target instanceof Water){
                effect *= 1.5;
            }
            break;
        case WATER:
            if(target instanceof Fire){
                effect *= 1.5;
            }
            break;
        case FIRE:
            if(target instanceof Ice){
                effect *= 1.5;
            }
            break;
        case ICE:
            if(target instanceof Wind){
                effect *= 1.5;
            }
            break;
        case WIND:
            if(target instanceof Earth){
                effect *= 1.5;
            }
            break;
        default:
            break;
    }
    target.setHP(target.getHP() - effect);
    System.out.println(user.getName() + " used Item Element on " + target.getName() + " with " + effect + " damage");
    System.out.println(target.getName() + " has " + target.getHP() + " HP left");
    }
}
