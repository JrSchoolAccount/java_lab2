import java.util.Scanner;

public class Game {
    private Maze maze;
    private Player player;

    public Game() {
        // Initialize the maze and player
        maze = new Maze(11, 11);

        // Set up the maze
        maze.getCell(2, 1).setSymbol('W');
        maze.getCell(3, 3).setSymbol('T');
        maze.getCell(4, 4).setSymbol('M');

        // Initialize the player and set its symbol
        player = new Player("Hero", 1, 1, 5, 3, 3);
        maze.getCell(player.getX(), player.getY()).setSymbol('P');
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            maze.printMap();
            System.out.println("Enter move (up, down, left, right):");
            input = sc.nextLine().toLowerCase();

            switch (input) {
                case "up":
                    player.move(0, -1, maze);
                    break;
                case "down":
                    player.move(0, 1, maze);
                    break;
                case "left":
                    player.move(-1, 0, maze);
                    break;
                case "right":
                    player.move(1, 0, maze);
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            maze.getCell(player.getX(), player.getY()).setSymbol('P');
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
