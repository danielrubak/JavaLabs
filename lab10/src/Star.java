import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star implements XmasShape {
    int x;
    int y;
    double scale;
    int pointNum;
    Color fillColor;
    Color lineColor;

    @Override
    public void render(Graphics2D g2d) {
        int xVector[] = {-1, 0, 1};
        int yVector[] = {0, -5, 0};

        for (int i = 0; i < this.pointNum; i++) {
            g2d.setColor(fillColor);
            g2d.fillPolygon(xVector, yVector, xVector.length);
            g2d.setColor(lineColor);
            g2d.drawPolygon(xVector, yVector, xVector.length);
            g2d.rotate(2*Math.PI/this.pointNum);
        }
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }

    public Star(int x, int y, double scale, int pointNum, Color fillColor, Color lineColor) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.pointNum = pointNum;
        this.fillColor = fillColor;
        this.lineColor = lineColor;
    }
}
