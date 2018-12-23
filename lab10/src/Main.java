import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Christmas Tree");
        DrawPanel drawPanel = new DrawPanel();
        frame.setContentPane(drawPanel);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        Bubble bubble = new Bubble(100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble);
        Branch branch = new Branch(50, 200, 100, 60, 1, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(branch);
    }
}
