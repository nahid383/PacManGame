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

    void loadImages(){
        wallImage = new ImageIcon("assets/wall.png").getImage();
        blueGhost = new ImageIcon("assets/blueGhost.png").getImage();
        orangeGhost = new ImageIcon("assets/orangeGhost.png").getImage();
        pinkGhost = new ImageIcon("assets/pinkGhost.png").getImage();
        redGhost = new ImageIcon("assets/redGhost.png").getImage();

        pacUp = new ImageIcon("assets/pacmanUp.png").getImage();
        pacDown = new ImageIcon("assets/pacmanDown.png").getImage();
        pacLeft = new ImageIcon("assets/pacmanLeft.png").getImage();
        pacRight = new ImageIcon("assets/pacmanRight.png").getImage();

        powerFoodImage = new ImageIcon("assets/powerFoodImage.png").getImage();
        cherryImage = new ImageIcon("assets/cherryImage.png").getImage();
        cherry2Image = new ImageIcon("assets/cherry2Image.png").getImage();
    }

    void loadMap(){
        for(int i=0; i<GameConfig.ROW_COUNT; i++){
            for(int j=0; j<GameConfig.COLUMN_COUNT; j++){
                char tile = MapLoader.MAP[i].charAt(j);

                int x = j*GameConfig.TILE_SIZE;
                int y = i*GameConfig.TILE_SIZE;

                if(tile == 'X'){
                    walls.add(new Wall(wallImage, x, y, 32, 32));
                } else if(tile == 'P'){
                    pacman = new Pacman(pacRight, x, y, 32, 32);
                } else if(tile == 'b'){
                    ghosts.add(new Ghost(blueGhost, x, y, 32, 32));
                } else if(tile == 'o'){
                    ghosts.add(new Ghost(orangeGhost, x, y, 32, 32));
                } else if(tile == 'C'){
                    foods.add(new Food(cherryImage, x, y, 20, 20));
                } else if(tile == '2'){
                    foods.add(new Food(cherry2Image, x, y, 20, 20));
                } else if(tile == ' '){
                    foods.add(new Food(powerFoodImage, x, y, 8, 8));
                }
            }
        }
    }
}