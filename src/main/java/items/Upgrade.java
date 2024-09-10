package items;

import game.Player;

public class Upgrade extends Item {
    private String type;
    private int bonus;

    public Upgrade(int x, int y, String type, int bonus) {
        super(x, y, 'U');
        this.type = type;
        this.bonus = bonus;
    }

    @Override
    public void interact(Player player) {
        if (type.equals("weapon")) {
            player.increaseAttack(bonus);
            System.out.println("You found a weapon!\nAttack increased by " + bonus);
        } else if (type.equals("armor")) {
            player.increaseDefense(bonus);
            System.out.println("You found armor!\nDefense increased by " + bonus);
        }
    }
}
