import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    Image img = Toolkit.getDefaultToolkit().getImage("src/lab10/bird1.jpeg");
    List<XmasShape> shapes = new ArrayList<>();

    /*public void paintComponent(Graphics g){
        g.setFont(new Font("Helvetica", Font.BOLD, 18));
        g.drawString("Hello World", 20, 20);

        // draw line
        g.drawLine(10,10,100,100);

        // draw ellipse
        g.setColor(Color.yellow);
        g.fillOval(100,101,30,30);
        g.setColor(Color.black);
        g.drawOval(100,101,30,30);

        // draw polygon
        int x[]={286,253,223,200,148,119,69,45,0};
        int y[]={0,101,89,108,79,95,66,80,56};
        g.fillPolygon(x,y,x.length);

        g.drawImage(img,0,0,getWidth(),getHeight(),this);

        System.out.println("painting");
    }*/

    DrawPanel(){
        setBackground(new Color(0,0,50));
        //setOpaque(true);
    }

    /*public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;

        // zachowaj macierz przekształcenia
        AffineTransform mat = g2d.getTransform();
        // przesuń początek układu
        g2d.translate(100,100);
        // zastosuj skalowanie
        g2d.scale(.2,.2);
        // narysuj linie
        for(int i=0;i<12;i++){
            g2d.drawLine(0,0,100,100);
            g2d.rotate(2*Math.PI/12);
        }
        //oddtwórz poprzednie ustawienia transformacji układu współrzędnych
        g2d.setTransform(mat);
    } */

    public void addShape (XmasShape xs) {
        this.shapes.add(xs);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
        }
    }
}
