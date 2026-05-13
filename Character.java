import java.awt.Image;

public abstract class Character extends GameObject implements Movable{
    protected int velocityX, velocityY;
    protected int startX, startY;
    protected char direction = 'R';

    public Character(Image image, int x, int y, int w, int h){
        super(image, x, y, w, h);
        startX = x;
        startY = y;

    }

    public void reset() {
        setX(startX);
        setY(startY);
        velocityX = 0;
        velocityY = 0;
    }
}