public class Game {
    public static void main(String[] args) {
    Maze maze = new Maze(11,11);

    maze.getCell(2,1).setSymbol('W');

    Player player = new Player("Hero", 1, 1, 5, 3, 3);
    maze.getCell(player.getX(), player.getY()).setSymbol('P');

    maze.getCell(3, 3).setSymbol('T');
    maze.getCell(4, 4).setSymbol('M');

    maze.printMap();
    }
}
