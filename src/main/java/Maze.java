import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<List<Cell>> grid;

    public Maze(int rowsX, int colsY) {
        grid = new ArrayList<>();
        for (int i = 0; i < rowsX; i++) {
            List<Cell> x = new ArrayList<>();
            for (int j = 0; j < colsY; j++) {
                if (i == 0 || i == rowsX - 1 || j == 0 || j == colsY - 1) {
                    x.add(new Cell(i, j, 'W'));
                } else {
                    x.add(new Cell(i, j));
                }
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
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                System.out.print(cell.getSymbol() + " ");
            }
            System.out.println();
        }
    }
}

