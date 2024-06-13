import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Screen1 extends JPanel {
    private ArrayList<Platform> platformList;
    private Doodle doodle;


    public Doodle getDoodle() {
        return doodle;
    }



    public Screen1 (int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        Screen1.
        this.setBackground(Color.BLACK);
        this.platformList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            this.platformList.add(new Platform());
        }
        this.doodle = new Doodle();
        this.mainGameLoop();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Platform platform : this.platformList) {
            platform.paint(g);
        }
        this.doodle.paint(g);
    }

    public void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                try {


                    doodle.Jump();
                    if (!this.doodle.isAlive()) {
                        this.doodle.dissmenal();
                    }
                    checkCollision ();
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private boolean checkCollision () {
        boolean collision = false;
        for (Platform platform : this.platformList) {
            if (platform.getPlatformAsCharacter().areColliding(this.doodle.getDoodleAsCharacter())) {
                collision = true;

            }
        }
        if (collision) {

        }

        return collision;
    }

}
/*for (Platform platform : this.platformList) {
                        platform.fall();
                    }*/