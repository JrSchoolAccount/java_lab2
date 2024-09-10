import items.*;
import game.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Maze maze;
    private Player player;
    private List<Monster> monsters;

    public App() {
        maze = new Maze(10, 12);
        monsters = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        int[][] wallPositions = {
                {1, 3}, {1, 5}, {1, 6}, {1, 7}, {1, 11},
                {2, 1}, {2, 3}, {2, 5}, {2, 6}, {2, 9}, {2, 11},
                {3, 5}, {3, 6}, {3, 9}, {3, 11},
                {4, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 9}, {4, 11},
                {5, 2}, {5, 9}, {5, 11},
                {6, 2}, {6, 5}, {6, 6}, {6, 9}, {6, 11},
                {7, 6}, {7, 7}, {7, 9}, {7, 11},
                {8, 9}, {8, 11}
        };

        for (int[] pos : wallPositions) {
            maze.setCell(pos[0], pos[1], new Wall(pos[0], pos[1]));
        }



        player = new Player("Hero", 0, 1, 10, 3, 3);

        monsters.add(new Monster("Goblin", 8, 1, 6, 2, 0));
        monsters.add(new Monster("Orc", 8, 9, 6, 3, 2));

        items.add(new Treasure(1, 2, 2));
        items.add(new Treasure(1, 8, 3));
        items.add(new Treasure(2, 4, 3));
        items.add(new Treasure(2, 10, 4));
        items.add(new Treasure(4, 10, 5));
        items.add(new Treasure(7, 3, 6));

        items.add(new Upgrade(1, 9, "weapon", 2));
        items.add(new Upgrade(3, 1, "armor", 2));
        items.add(new Upgrade(5, 4, "weapon", 2));
        items.add(new Upgrade(7, 5, "armor", 2));

        items.add(new Exit(9,10));

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
            displayPlayerStats();
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
            MoveMonsters();
        }
    }

    private void MoveMonsters() {
        for (Monster monster : monsters) {
            int dx = Integer.compare(player.getX(), monster.getX());
            int dy = Integer.compare(player.getY(), monster.getY());

            boolean isAdjacent = isAdjacent(monster);

            if (!isAdjacent) {
                monster.move(dx, dy, maze);
            }

            maze.updateMonsterPosition(monsters);
        }
    }

    private boolean isAdjacent(Monster monster) {
        return Math.abs(player.getX() - monster.getX()) <= 1 &&
                Math.abs(player.getY() - monster.getY()) <= 1;
    }

    private void displayPlayerStats() {
        System.out.println(
                "Name: " + player.getName() +
                ", HP: " + player.getHealth() +
                ", ATK: " + player.getAttack() +
                ", DEF: " + player.getDefense() +
                ", Score: " + player.getPoints());
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}
