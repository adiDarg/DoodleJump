import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private final Doodle doodle;
    private List<Platform> platforms;
    private boolean arePlatformsAdded;
    private final int MIN_PLATFORM_LENGTH = 80;
    private final int MAX_PLATFORM_LENGTH = 100;
    private final int PLATFORM_HEIGHT = 20;
    private final int SCREEN_WIDTH;
    private final int SCREEN_HEIGHT;
    private final int FPS;
    private Thread gameThread;
    private DoodleKeyListener keyListener;
    private final Image BACKGROUND;
    public GamePanel(int x, int y, int width, int height, int FPS, Image background){
        this.BACKGROUND = background;
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
        this.FPS = FPS;
        this.arePlatformsAdded = false;
        setBounds(x,y,SCREEN_WIDTH,SCREEN_HEIGHT);
        setLayout(null);
        setFocusable(false);
        platforms = new ArrayList<>();
        Platform.generatePlatforms(MIN_PLATFORM_LENGTH,MAX_PLATFORM_LENGTH,PLATFORM_HEIGHT, 0, SCREEN_HEIGHT,SCREEN_WIDTH, (ArrayList<Platform>) platforms);
        doodle = new Doodle(SCREEN_WIDTH,SCREEN_HEIGHT,SCREEN_WIDTH/2,2*SCREEN_HEIGHT/3);
        Platform starter = new Platform(MAX_PLATFORM_LENGTH,PLATFORM_HEIGHT,SCREEN_WIDTH/2 - MAX_PLATFORM_LENGTH/2,2*SCREEN_HEIGHT/3 + doodle.getHEIGHT());
        platforms.add(starter);
        keyListener = new DoodleKeyListener(doodle, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, SCREEN_WIDTH);
        addKeyListener(keyListener);
        setVisible(false);
    }
    private void adjustScreen(){
        for (int i = 1; i <= FPS; i++){
            int yDifference = (int) ((Math.pow(doodle.getMAX_SPEED(),2)/ (2 * doodle.getCurrentGravity()) + doodle.getHEIGHT())/FPS);

            if (i % 15 == 0){
                arePlatformsAdded = true;
                Platform.generatePlatforms(MIN_PLATFORM_LENGTH,MAX_PLATFORM_LENGTH,PLATFORM_HEIGHT, -yDifference,0,SCREEN_WIDTH, (ArrayList<Platform>) platforms);
                arePlatformsAdded = false;
            }
            doodle.setY(doodle.getY() + yDifference);

            for (Platform platform: platforms){
                platform.lower(yDifference);
            }

            try {
                Thread.sleep(500/FPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void startGameThread(){
        requestFocus();
        gameThread = new Thread(() -> {
            while (true) {
                double deltaSeconds = (double) FPS / 1000;
                doodle.checkCollision(deltaSeconds,platforms);
                new Thread(()->doodle.moveHorizontal(SCREEN_WIDTH)).start();
                doodle.moveVertically(deltaSeconds);
                if (doodle.getSpeed() <= doodle.getMAX_SPEED() + (double) (doodle.getCurrentGravity() * FPS) / 1000 && doodle.getY() <= SCREEN_HEIGHT/2 && doodle.getMaxHeight() > (double) SCREEN_HEIGHT / 2 + doodle.getMAX_SPEED())
                    new Thread(this::adjustScreen).start();
                if (doodle.hasLost(SCREEN_HEIGHT)){
                    break;
                }
                repaint();
                try {
                    Thread.sleep(1000/FPS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        gameThread.start();
        //ADD LOST SCREEN
    }
    public void pause(){
        try {
            gameThread.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void resume(){
        startGameThread();
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(BACKGROUND,0,0,null);
        doodle.paint(graphics);
        if (arePlatformsAdded)
            return;
        for (Platform platform: platforms){
            platform.paint(graphics);
        }
    }
}