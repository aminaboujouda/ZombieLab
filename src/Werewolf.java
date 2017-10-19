import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Werewolf is a class defining the data of a 
 * character in the game - a Werewolf in particular.
 * <p>
 * Werewolf implements {@link GraphicsUpdater}, which 
 * means a Werewolf object can draw itself to a {@link Graphics} object.
 * <p>

 * @author Freddy Falcon
 * @version 1.0.0
 * @since 1.0
 */
class Werewolf extends Sprite implements GraphicsUpdater {	

	/**
	 * A Werewolf constructor. 
	 *
	 * @param x
	 *            x-coordinate of a Werewolf object.
	 * @param y
	 *            y-coordinate of a Werewolf object.
	 */
	Werewolf( int x, int y ){
		super(x, y, Settings.WEREWOLF_SIZE, Settings.WEREWOLF_SPEED, Settings.WEREWOLF_IMAGE);
	}	
	
	@Override
	public void updatePosition( ) {
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