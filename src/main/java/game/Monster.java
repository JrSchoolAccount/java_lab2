package game;

public class Monster implements Movable, Obstacle {
    private String name;
    private int x, y, health, attack, defense;

    public Monster(String name, int x, int y, int health, int attack, int defense) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }


    @Override
    public void move(int dx, int dy, Maze maze) {

        if (maze.isWalkable(x + dx, y)) {
            x += dx;
        } else if (maze.isWalkable(x, y + dy)) {
            y += dy;
        } else if (maze.isWalkable(x - dx, y)) {
            x -= dx;
        } else if (maze.isWalkable(x, y - dy)) {
            y -= dy;
        }
    }

    @Override
    public boolean isBlocking() {
        return true;
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

}