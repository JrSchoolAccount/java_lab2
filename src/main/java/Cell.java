public class Cell {
    private int x, y;
    private char symbol;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = '.';
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
}
