import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Human is a class defining the data of a 
 * character in the game - a Human in particular.
 * <p>
 * Human implements {@link GraphicsUpdater}, which 
 * means a Human object can draw itself to a {@link Graphics} object.
 * <p>

 * @author Mitchell Books
 * @version 1.0.1
 * @since 1.0
 */
class Human extends Sprite implements GraphicsUpdater {	

	/**
	 * A Human constructor. 
	 *
	 * @param x
	 *            x-coordinate of a Human object.
	 * @param y
	 *            y-coordinate of a Human object.
	 */
	Human( int x, int y ){
		super(x, y, Settings.HUMAN_SIZE, Settings.HUMAN_SPEED, Settings.HUMAN_IMAGE);
	}

	/**
	 * Update Position
	 *
	 * updates the position for human object.
	 * overrides the {@link Sprite} update position function.
	 */
	@Override
	public void updatePosition() {
    	if (x < dest_x) {
    		int min = dest_x - x < speed ? dest_x - x : speed; 
    		x += min;
    	} else if (x > dest_x) {
    		int min = x - dest_x < speed ? x - dest_x : speed; 
    		x -= min;
    	}
    	        
    	if (y < dest_y) {
    		int min = dest_y - y < speed ? dest_y - y : speed; 
    		y += min;
    	} else if (y > dest_y) {
    		int min = y - dest_y < speed ? y - dest_y : speed; 
    		y -= min;
    	}
	}
	
}