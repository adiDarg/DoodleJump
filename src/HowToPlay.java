import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageProducer;

public class HowToPlay extends JButton {
    public static final int HOW_TO_PLAY_BUTTOM_WIDTH = 300;
    public static final int HOW_TO_PLAY_BUTTOM_HEIGHT= 60;

    public HowToPlay(int x, int y){
        this.setBounds(x, y, HOW_TO_PLAY_BUTTOM_WIDTH,HOW_TO_PLAY_BUTTOM_HEIGHT);
        this.setText("how to play");


    }




}
