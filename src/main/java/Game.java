import java.util.Scanner;

public class Game {
    private Maze maze;
    private Player player;

    public Game() {
        maze = new Maze(9, 9);

        maze.setCell(2, 1, new Wall(2, 1));

        player = new Player("Hero", 0, 1, 5, 3, 3);
        maze.getCell(player.getX(), player.getY()).setSymbol('P');
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            maze.printMap();
            System.out.println("\nEnter move (up, down, left, right):");
            input = sc.nextLine().toLowerCase();

            switch (input) {
                case "up":
                    player.move(-1, 0, maze);
                    break;
                case "down":
                    player.move(1, 0, maze);
                    break;
                case "left":
                    player.move(0, -1, maze);
                    break;
                case "right":
                    player.move(0, 1, maze);
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
