import java.awt.Graphics;
import java.util.*;

/**
 * Model is the class
 * that manages all data about
 * game horde.
 * <p>
 * This class implements GraphicsUpdater, which means that
 * it can be used to update a frame of animation.
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link Zombie}
 * <li>{@link Werewolf}
 * <li>{@link Human}
 * </ul>
 *
 * @author Mitchell Books
 * @version 1.0.1
 * @since 1.0
 */
public class Model implements GraphicsUpdater {
    private ArrayList<Sprite> horde;
    private Sprite player = null;

    /**
     * Model
     * <p>
     * A Model constructor that creates a horde of enemies
     * with a random position.
     *
     * @param hordeSize - number of enemies to make for the horde
     */
    public Model(int hordeSize) {
        System.out.println("Model()");
        horde = new ArrayList(hordeSize);
        for (int i = 0; i < hordeSize; i++) {
            Random r = new Random();
            int x = r.nextInt(Settings.WIDTH);
            int y = r.nextInt(Settings.HEIGHT);
            horde.add(new Zombie(x, y));
        }
        for (int i = 0; i < hordeSize; i++) {
            Random r = new Random();
            int x = r.nextInt(Settings.WIDTH);
            int y = r.nextInt(Settings.HEIGHT);
            horde.add(new Werewolf(x, y));
        }
    }


    /**
     * A method that updates the {@link Graphics} object
     * used by the view. The {@link Zombie}, {@link Human}, and {@link Werewolf}positions are also
     * updated when this method is called.
     *
     * @param g A {@link Graphics} object reference. The model
     *          can update a {@link Graphics} object with {@link Zombie} data.
     */
    @Override
    public void update(Graphics g) {
        for (int i = 0; i < horde.size(); i++) {
            horde.get(i).updatePosition();
            horde.get(i).update(g);
        }
        if (player != null) {
            player.updatePosition();
            player.update(g);
        }
    }

    /**
     * A method for setting the (x, y) coordinates of a the horde
     * managed by the Model. Sets a Human if there is no player.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setSpriteDestinations(int x, int y) {
        if (player == null) {
            System.out.println( 'Human Created' );
            player = new Human(x, y);
        } else {

            for (int i = 0; i < horde.size(); i++) {
                horde.get(i).setDest(player.getX(), player.getY());
            }
            player.setDest(x, y);
        }
    }

}