import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

        Branch branch1 = new Branch(500, 700, 450, 550, 1, new Color(15, 224, 95), new Color(15, 224, 95));
        Branch branch2 = new Branch(500, 550, 350, 450, 1, new Color(15, 224, 95), new Color(15, 224, 95));
        Branch branch3 = new Branch(500, 400, 250, 350, 1, new Color(15, 224, 95), new Color(15, 224, 95));
        Branch branch4 = new Branch(500, 250, 150, 200, 1, new Color(15, 224, 95), new Color(15, 224, 95));
        List<Branch> branches = new ArrayList<>();
        branches.add(branch1);
        branches.add(branch2);
        branches.add(branch3);
        branches.add(branch4);
        Tree christmasTree = new Tree (500, 700, 1, new Color(15, 224, 95), new Color(15, 224, 95), branches);
        //drawPanel.addShape(christmasTree);

        Bubble bubble = new Bubble(350, 600, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        //drawPanel.addShape(bubble);

        Star star = new Star(150,150,20, Color.yellow, Color.yellow);
        drawPanel.addShape(star);
    }
}
