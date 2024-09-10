package items;

import game.Player;

public class Exit extends Item {
    public Exit(int x, int y) {
        super(x, y, 'X');
    }

    @Override
    public void interact(Player player) {
        System.out.println("You escaped the dungeon and won the game!\nScore: " + player.getPoints());
        System.exit(0);
    }
}
