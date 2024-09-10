package game;

import items.Item;

public class Cell {
    private int x, y;
    private char symbol;
    private Item item;

    public Cell(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Cell(int x, int y) {
        this(x, y, '.');
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

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        this.symbol = item != null ? item.getSymbol() : '.';
    }
}
