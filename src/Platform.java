import java.awt.*;
import java.util.List;
import java.util.Random;

public class Platform extends gameObject {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 15;
    private final int MINIMUM_Y_DISTANCE = 100;
    private final int MINIMUM_X_DISTANCE = 200;
    Random random = new Random();
    int x1 = random.nextInt(0, Window.WIDTH);
    int y1 = random.nextInt(0, Window.HEIGHT);
    public Platform() {
        super(1,1,80,15);
        this.setX(x1);
        this.setY(y1);
    }

    public void fall () {
        this.y++;
        if (this.y >= Window.HEIGHT) {
            this.x = new Random().nextInt(0, Window.WIDTH);
            this.y = new Random().nextInt(-200, 0);
        }
    }
    public void addToList(List<Platform> platformList, int lowerBound, int upperBound, int screenWidth){
        Random random = new Random();
        boolean validLocation = false;
        while (!validLocation){
            x = random.nextInt(0,screenWidth);
            y = random.nextInt(lowerBound,upperBound);
            for (Platform platform : platformList) {
                if (platform.y < lowerBound || platform.y > upperBound) {
                    continue;
                }
                if (Math.abs(this.y - platform.y) < MINIMUM_Y_DISTANCE && Math.abs(this.x - platform.x) < MINIMUM_X_DISTANCE) {
                    validLocation = true;
                }
            }
        }
        platformList.add(this);
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect(x,y,WIDTH,HEIGHT);
    }

    public gameObject getPlatformAsCharacter() {
        return new gameObject(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}

