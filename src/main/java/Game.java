import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Maze maze;
    private Player player;
    private List<Monster> monsters;
    private List<Item> items;

    public Game() {
        maze = new Maze(9, 9);
        monsters = new ArrayList<>();
        items = new ArrayList<>();

        maze.setCell(2, 1, new Wall(2, 1));

        player = new Player("Hero", 0, 1, 5, 3, 3);

        monsters.add(new Monster("Goblin", 4, 4, 10, 2, 1));
        monsters.add(new Monster("Orc", 5, 5, 15, 3, 3));

        items.add(new Treasure(1, 1, 2));
        items.add(new Treasure(2, 3, 2));


        maze.getCell(player.getX(), player.getY()).setSymbol('P');

        for (Monster monster : monsters) {
            maze.getCell(monster.getX(), monster.getY()).setSymbol('M');
        }

        for (Item item : items) {
            maze.getCell(item.getX(), item.getY()).setItem(item);
        }
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
            for (Monster monster : monsters) {
                int dx = Integer.compare(player.getX(), monster.getX());
                int dy = Integer.compare(player.getY(), monster.getY());

                monster.move(dx, dy, maze);
                maze.updateMonsterPosition(monsters);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
