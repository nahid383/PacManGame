import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import  javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    private Image wallImage;
    private Image blueGhost, orangeGhost, pinkGhost, redGhost;
    private Image pacUp, pacDown, pacLeft, pacRight;
    private Image powerFoodImage;
    private Image cherryImage;
    private Image cherry2Image;

    private HashSet<Wall> walls = new HashSet<>();
    private HashSet<Food> foods = new HashSet<>();
    private HashSet<Ghost> ghosts = new HashSet<>();

    private Pacman pacman;
    private Timer timer;
    private Random random = new Random();

    private char[] directions = {'U', 'D', 'L', 'R'};
    
    public GamePanel(){
        setPreferredSize(new Dimension(GameConfig.BOARD_WIDTH, GameConfig.BOARD_HEIGHT));

        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        loadImages();
        loadMap();

        timer = new Timer(50, this);
        timer.start();
    }
}