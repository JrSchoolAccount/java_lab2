import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<List<Cell>> grid;

    public Maze(int rowsX, int colsY) {
        grid = new ArrayList<>();
        for (int i = 0; i < rowsX; i++) {
            List<Cell> x = new ArrayList<>();
            for (int j = 0; j < colsY; j++) {
                x.add(new Cell(i, j));
            }
            grid.add(x);
        }
    }

    public Cell getCell(int x, int y) {
        return grid.get(x).get(y);
    }

    public void setCell(int x, int y, Cell cell) {
        grid.get(x).set(y, cell);
    }

    public void printMap() {
        for (List<Cell> x : grid) {
            for (Cell cell : x) {
                System.out.println(cell.getSymbol() + " ");
            }
            System.out.println();
        }
}
}

