import java.util.ArrayList;
import java.util.List;

public class Player implements Movable {
    private String name;
    private int x, y, health, attack, defense;
    private int damageTaken, points = 0;
    private List<Item> items;

    public Player(String name, int x, int y, int health, int attack, int defense) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.items = new ArrayList<>();
    }

    @Override
    public void move(int dx, int dy, Maze maze) {
        int newX = x + dx;
        int newY = y + dy;
        if (maze.isWalkable(newX, newY)) {
            x = newX;
            y = newY;
            // item interaction HERE
        }
        else {
            System.out.println("You can't move there!!");
        }
    }

    public void pickUpItem(Item item) {
        items.add(item);
        // item.applyEffect(this);
    }

    public void destroyItem(Item item) {
        items.remove(item);
        // item.removeEffect(this);
    }

    public void heal(int amount) {
        damageTaken -= amount;
        if (damageTaken < 0) {
            damageTaken = 0;
        }
    }

    public int getRemainingHealth() {
        return this.health - this.damageTaken;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getPoints() {
        return points;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void increaseAttack(int value) {
        attack += value;
    }

    public void increaseDefense(int value) {
        defense += value;
    }

    public void addPoints(int value) {
        points += value;
    }
}
