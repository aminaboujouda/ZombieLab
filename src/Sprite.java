import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Sprite is a class defining the data of a 
 * character in the game.
 * <p>
 * Sprite implements {@link GraphicsUpdater}, which 
 * means a Sprite object can draw itself to a {@link Graphics} object.
 * <p>

 * @author Amin Aboujouda
 * @version 1.0.1
 * @since 1.0.1
 */
abstract public class Sprite implements GraphicsUpdater {
	public Image image;
	public int x;
	public int y;
	public int dest_x;
	public int dest_y;
	public int size;
	public int speed = 10;
	/**
	 * A Sprite constructor. 
	 *
	 * @param x
	 *            x-coordinate of a sprite object.
	 * @param y
	 *            y-coordinate of a sprite object.
	 * @param size
	 *            size of a sprite object.
	 * @param speed
	 *            speed of a sprite object.
	 * @param string imageName
	 *            path to an image file.
	 */
	Sprite(int x, int y, int size, int speed, String imageName){
		try {
	    	image = ImageIO.read(new File(imageName));
	    } catch (IOException ioe) {
	    	System.out.println("Unable to load image file.");
	    }
		setPos(x,y);
		setDest(x,y);
		setSize(size);
		setSpeed(speed);
	}	
	/**
	 * Implementation of {@link GraphicsUpdater#update}. 
	 *
	 * @param g
	 *         The {@link Graphics} object to be modified.
	 */
	@Override
    public void update(Graphics g) {
		g.drawImage( image, x, y, size, size, null);
	}
	
	/**
	 * A method that uses a Zombie object's current 
	 * position, destination, and speed to calculate 
	 * a new (x, y) position for the Zombie object.
	 * <p>
	 * This method modifies the x and y fields of a Zombie object. 
	 *
	 */
	public abstract void updatePosition( );
         	

    // Misc. setters and getters
	public Image getImage() { return image; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void setDest(int x, int y) {
		dest_x = x - getSize()/2;
    	dest_y = y - getSize()/2;
	}
    
    public void setPos(int x, int y) {
		this.x = x - getSize()/2;
		this.y = y - getSize()/2;
	}
    
	public int getSize() {	return size; }
	public void setSize(int size)   { this.size = size;   }
	public void setSpeed(int speed)   { this.speed = speed;   }
	
}
