import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star implements XmasShape {
    int x;
    int y;
    double scale;
    Color fillColor;
    Color lineColor;

    @Override
    public void render(Graphics2D g2d) {

        int xPoints[] = {9, 15, 0, 18, 3};
        int yPoints[] = {0, 18, 6, 6, 18};


        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();

        g2d.setColor(fillColor);
        g2d.fill(star);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }

    public Star(int x, int y, double scale, Color fillColor, Color lineColor) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.fillColor = fillColor;
        this.lineColor = lineColor;
    }
}
