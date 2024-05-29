package main;


import javax.swing.*;
import java.awt.*;

public class


Main {
    public static JFrame getWindow() {
        return window;
    }

    public static JFrame window;


    
    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // Cant Resizable
        window.setTitle("Code Name: Innie\n"); // Window Name
        new Main().setIcon();

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.config.loadConfig();
        if(gamePanel.fullScreenOn == true)
        {
            window.setUndecorated(true);
        }

        window.pack(); // Resizes to prefered size and prevents overflow.

        window.setLocationRelativeTo(null); // Starts center of screen
        window.setVisible(true);

        gamePanel.setupGame(); // Setting up the game before starts
        gamePanel.startGameThread();
    }
    public void setIcon()
    {
       // change icon 
      // ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("player/icon.png"));
       
      ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("player/boy_guard_down.png"));

        window.setIconImage(icon.getImage());
    }
}