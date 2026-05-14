import java.awt.Image;

public class Ghost extends Character{
    public Ghost(Image image, int x, int y, int w, int h){
        super(image, x, y, w, h);
    }

    @Override
    public void move(){
        setX(getX() + velocityX);
        setY(getY() + velocityY);
    }

    
    
}