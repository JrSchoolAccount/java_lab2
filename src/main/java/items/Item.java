package items;

import game.Player;

public abstract class Item {
    private int x, y;
    private char symbol;


    public Item(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract void interact(Player player);
}

