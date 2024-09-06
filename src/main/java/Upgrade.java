public class Upgrade extends Item {
    private String type;
    private int bonus;

    public Upgrade(int x, int y, String type, int bonus) {
        super(x, y, type.equals("weapon") ? 'W' : 'A');
        this.type = type;
        this.bonus = bonus;
    }

    @Override
    public void interact(Player player) {
        if (type.equals("weapon")) {
            System.out.println("You found a weapon! Attack increased by " + bonus);
            player.increaseAttack(bonus);
        } else if (type.equals("armor")) {
            System.out.println("You found armor! Defense increased by " + bonus);
            player.increaseDefense(bonus);
        }
    }
}
