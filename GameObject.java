import java.awt.Image;

public class GameObject{
    private int x, y, width, height;
    private Image image;

    public GameObject(Image image, int x, int y, int width, int height){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}