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
        drawPanel.addShape(christmasTree);

        Bubble bubble1 = new Bubble(350, 600, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble1);
        Bubble bubble2 = new Bubble(400, 470, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble2);
        Bubble bubble3 = new Bubble(660, 630, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble3);
        Bubble bubble4 = new Bubble(450, 300, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble4);
        Bubble bubble5 = new Bubble(580, 545, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble5);
        Bubble bubble6 = new Bubble(500, 200, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble6);
        Bubble bubble7 = new Bubble(540, 400, 100, 100, 0.5, new Color(255, 255, 255), new Color(255, 105, 180));
        drawPanel.addShape(bubble7);

        Star star = new Star(500,120,9,5, Color.yellow, Color.yellow);
        drawPanel.addShape(star);
    }
}
