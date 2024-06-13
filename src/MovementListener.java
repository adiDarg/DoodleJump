import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class MovementListener implements KeyListener {
    private MainScene mainScene;

    public MovementListener(MainScene mainScene) {
        this.mainScene = mainScene;
    }
    boolean isUP = false, isDown = false, isRight = false,isLeft = false;

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.repaint();
        }
        if (isUP && isRight){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
        }
        if (isDown && isRight){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
        }
        if (isUP && isLeft){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
        }
        if (isDown && isLeft){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
        }



    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
            isDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){

            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
            isUP = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.repaint();
            isLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.repaint();
            isRight = true;
        }
        if (isUP && isRight){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
        }
        if (isDown && isRight){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
        }
        if (isUP && isLeft){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
        }
        if (isDown && isLeft){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mainScene.getDoodle2().moveDown();
            this.mainScene.repaint();
            isDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.mainScene.getDoodle2().moveUp();
            this.mainScene.repaint();
            isUP = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.mainScene.getDoodle2().moveLeft();
            this.mainScene.repaint();
            isLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.mainScene.getDoodle2().moveRight();
            this.mainScene.repaint();
            isRight = false;
        }
    }
}
