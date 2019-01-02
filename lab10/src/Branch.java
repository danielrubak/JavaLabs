import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Branch implements XmasShape {
    int x;
    int y;
    int height;
    int width;
    double scale;
    Color lineColor;
    Color fillColor;
    int xVector[];
    int yVector[];

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(fillColor);
        g2d.fillPolygon(xVector, yVector, xVector.length);
        g2d.setColor(lineColor);
        g2d.drawPolygon(xVector, yVector, xVector.length);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x, y);
        if ( scale != 1 ) {
            g2d.scale(scale, scale);
        }
    }

    public Branch(int x, int y, int height, int width, double scale, Color lineColor, Color fillColor) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.scale = scale;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
        this.xVector = new int[]{-width / 2, 0, width / 2};
        this.yVector = new int[]{0, -height, 0};
    }

    public int[] getXVector() {
        return this.xVector;
    }

    public int[] getYVector() {
        return this.yVector;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth () {
        return this.width;
    }

    public int getY() {
        return this.y;
    }
}
