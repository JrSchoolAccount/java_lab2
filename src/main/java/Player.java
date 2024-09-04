import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int x, y;
    private int health = 10;
    private int attack = 3;
    private int defence = 3;
    private int damageTaken = 0;
    private List<Item> items;

    public Player(String name, int x, int y, int health, int attack, int defence) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.items = new ArrayList<>();
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void pickUpItem(Item item) {
        items.add(item);
        item.applyEffect(this);
    }

    public void destroyItem(Item item) {
        items.remove(item);
        item.removeEffect(this);
    }

    public void heal(int amount) {
        damageTaken -= amount;
        if (damageTaken < 0) {
            damageTaken = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getDamageTaken() {
        return damageTaken;
    }
}
