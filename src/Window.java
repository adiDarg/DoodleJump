import javax.swing.*;

public class Window extends JFrame {

    public static final int WINDOW_WIDTH = 550;
    public static final int WINDOW_HEIGHT= 800;


    public Window(){
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Menu menu = new Menu();
        this.add(menu);

    }



}
