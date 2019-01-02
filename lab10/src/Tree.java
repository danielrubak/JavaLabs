import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tree implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;
    List<Branch> branches = new ArrayList<>();

    @Override
    public void render(Graphics2D g2d) {
        List<Integer> xVectorLeft = new ArrayList<Integer>();
        List<Integer> xVectorRight = new ArrayList<Integer>();
        List<Integer> yVectorLeft = new ArrayList<Integer>();
        List<Integer> yVectorRight = new ArrayList<Integer>();
        int numOfBranches = this.branches.size();

        int tempY = 0;
        int tempX;

        for ( int i = 0; i < numOfBranches; i++ ) {
            Branch b = branches.get(i);
            int xTempVector[] = b.getXVector();
            int yTempVector[] = b.getYVector();

            if ( i == numOfBranches - 1 ) {
                xVectorLeft.add(xTempVector[0]);
                yVectorLeft.add(-tempY);
                xVectorLeft.add(0);
                yVectorLeft.add(-tempY - b.getHeight());
                xVectorLeft.add(xTempVector[2]);
                yVectorLeft.add(-tempY);

            } else if ( i == 0) {
                xVectorLeft.add(xTempVector[0]);
                yVectorLeft.add(yTempVector[0]);

                tempY = b.getY() - branches.get(i+1).getY();
                tempX = ((b.getWidth()/2) * tempY)/(b.getHeight());
                xVectorLeft.add(xTempVector[0]+tempX);
                yVectorLeft.add(-tempY);

                xVectorRight.add(0, xTempVector[2]);
                yVectorRight.add(0, yTempVector[2]);

                xVectorRight.add(0, xTempVector[2]-tempX);
                yVectorRight.add(0, -tempY);

            } else {
                xVectorLeft.add(xTempVector[0]);
                yVectorLeft.add(-tempY);

                xVectorRight.add(0, xTempVector[2]);
                yVectorRight.add(0, -tempY);

                tempY += b.getY() - branches.get(i+1).getY();
                tempX = ((b.getWidth()/2) * (b.getY() - branches.get(i+1).getY()))/(b.getHeight());
                xVectorLeft.add(xTempVector[0]+tempX);
                yVectorLeft.add(-tempY);

                xVectorRight.add(0,xTempVector[2]-tempX);
                yVectorRight.add(0,-tempY);
            }
        }

        xVectorLeft.addAll(xVectorRight);
        yVectorLeft.addAll(yVectorRight);

        // debug mode
        for ( int k = 0; k < xVectorLeft.size(); k++) {
            System.out.println(xVectorLeft.get(k) + ", " + yVectorLeft.get(k));
        }

        int[] xVec = xVectorLeft.stream().mapToInt(i -> i).toArray();
        int[] yVec = yVectorLeft.stream().mapToInt(i -> i).toArray();

        g2d.setColor(fillColor);
        g2d.fillPolygon(xVec, yVec, xVec.length);
        g2d.setColor(lineColor);
        g2d.drawPolygon(xVec, yVec, xVec.length);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x, y);
        if ( scale != 1 ) {
            g2d.scale(scale, scale);
        }
    }

    public Tree (int x, int y, double scale, Color lineColor, Color fillColor, List<Branch> branches) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
        this.branches = branches;
    }
}
