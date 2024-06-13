import java.awt.*;

public class Doodle extends gameObject {
    private boolean alive;

    public Doodle() {
        super(Window.WIDTH/2,600,20,80);
        this.alive = true;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(x,y,width,height);
    }

    public gameObject getDoodleAsCharacter () {
        return new gameObject(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    public boolean isAlive () {
        return this.alive;
    }

    public void die () {
        this.alive = false;
    }

    public void dieMove (Graphics graphics) {
    }
    public void Jump() {
    }
    public void dissmenal() {
        System.exit(22);
    }
}

