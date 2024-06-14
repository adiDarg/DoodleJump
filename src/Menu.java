import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel  {

    public String gameName;
    private HowToPlay howToPlay;
    private JButton startGame;

    public Menu(){
        gameName ="Doodle Jump";
        this.setBounds(0,0, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        this.setLayout(null);
        howToPlay = new HowToPlay((Window.WINDOW_WIDTH-howToPlay.HOW_TO_PLAY_BUTTOM_WIDTH)/2-1, Window.WINDOW_HEIGHT/2);
//        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Owner\\Desktop\\Doodle Jump Project");
//        this.imageUpdate(backgroundImage.getImage(), 5, 0,0, windowWidth, windowHeight);
        this.add(howToPlay);
        createPlayButton();
    }

    private void createPlayButton(){
        final int PLAY_BUTTOM_WIDTH = 300;
        final int PLAY_BUTTOM_HEIGHT= 60;
        startGame= new JButton();
        startGame.setBounds((Window.WINDOW_WIDTH-PLAY_BUTTOM_WIDTH)/2-1, Window.WINDOW_HEIGHT/2+100, PLAY_BUTTOM_WIDTH, PLAY_BUTTOM_HEIGHT);
        startGame.setText("play");
        this.add(startGame);
    }




}
