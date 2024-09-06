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
                    x.add(new Wall(i, j));
                } else {
                    x.add(new Cell(i, j));
                }
            }
            grid.add(x);
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.size() || y >= grid.getFirst().size()) {
            throw new IndexOutOfBoundsException("Cell coordinates out of bounds");
        }
        return grid.get(x).get(y);
    }

    public void setCell(int x, int y, Cell cell) {
        if (x < 0 || y < 0 || x >= grid.size() || y >= grid.getFirst().size()) {
            throw new IndexOutOfBoundsException("Cell coordinates out of bounds");
        }
        grid.get(x).set(y, cell);
    }

    public boolean isWalkable(int x, int y) {
        Cell cell = getCell(x, y);
        if (cell instanceof Obstacle) {
            return !((Obstacle) cell).isBlocking();
        }
        return true;
    }

    public void printMap() {
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                System.out.print(cell.getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void updatePlayerPosition(Player player) {
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                if (cell.getSymbol() == 'P') {
                    cell.setSymbol('.');
                }
            }
        }
        getCell(player.getX(), player.getY()).setSymbol('P');
    }
}

