import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Window extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1200;

    public Window () {
        Screen1 screen1 = new Screen1(0, 0, WIDTH, HEIGHT);
        this.add(screen1);
        ImageIcon imageIcon = new ImageIcon("Background/ggg.jpg");
        Image scaledImage = imageIcon.getImage().getScaledInstance(WIDTH,HEIGHT,100);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel();
        label.setIcon(scaledIcon);
        //screen1.add(label);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }
}