package game;

public class Wall extends Cell implements Obstacle {

    public Wall(int x, int y) {
        super(x, y, 'W');
    }

    @Override
    public boolean isBlocking() {
        return true;
    }
}
