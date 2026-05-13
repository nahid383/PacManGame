import java.awt.Image;

public class Pacman extends Character{
    public Pacman(Image image, int x, int y, int w, int h){
        super(image, x, y, w, h);
    }

    @Override 
    public void move() {
        setX(getX() + velocityX);
        setY(getY() + velocityY);
    }

    @Override
    public void updateDirection(char d){
        direction = d;
        
    }
}