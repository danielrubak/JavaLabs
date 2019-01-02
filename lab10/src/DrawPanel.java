import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    // Image img = Toolkit.getDefaultToolkit().getImage("src/lab10/bird1.jpeg");
    List<XmasShape> shapes = new ArrayList<>();

    DrawPanel() {
        setBackground(new Color(100, 149, 237));
        //setOpaque(true);
    }

    public void addShape(XmasShape xs) {
        this.shapes.add(xs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (XmasShape s : shapes) {
            s.draw((Graphics2D) g);
        }
    }
}
