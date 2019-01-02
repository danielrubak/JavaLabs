import java.awt.*;
import java.awt.geom.AffineTransform;

public interface XmasShape {
    /**
     * Moves the origin of the coordinate system to the given place, scales object and if needs rotate it
     * @param g2d Graphics2D - graphical context
     */
    void transform(Graphics2D g2d);

    /**
     * Contains the code that draws the elements
     * @param g2d Graphics2D - graphical context
     */
    void render(Graphics2D g2d);

    /**
     * Standard draw method implementation
     * @param g2d Graphics2D - graphical context
     */
    default void draw(Graphics2D g2d){
        // Get the current transform
        AffineTransform saveAT = g2d.getTransform();

        // Perform transformation
        transform(g2d);

        // Render
        render(g2d);

        // Restore original transform
        g2d.setTransform(saveAT);
    }
}
