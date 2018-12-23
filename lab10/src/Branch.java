import java.awt.*;

public class Branch implements XmasShape {
    int x;
    int y;
    int height;
    int width;
    double scale;
    Color lineColor;
    Color fillColor;

    @Override
    public void render(Graphics2D g2d) {
        int xVector[] = {-width/2, width/2, 0};
        int yVector[] = {y, y, -height};
        g2d.setColor(fillColor);
        g2d.setColor(lineColor);
        g2d.fillPolygon(xVector, yVector, xVector.length);
    }

    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }

    public Branch(int x, int y, int height, int width, double scale, Color lineColor, Color fillColor) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.scale = scale;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }
}
