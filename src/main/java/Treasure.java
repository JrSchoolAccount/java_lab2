public class Treasure extends Item {
    private final int value;

    public Treasure(int x, int y, int value) {
        super(x, y,'T');
        this.value = value;
    }

    @Override
    public void interact(Player player) {
        player.addPoints(value);
        System.out.println("You found a treasure worth " + value + " points!");
    }
}
