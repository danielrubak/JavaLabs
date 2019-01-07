import sun.java2d.loops.DrawGlyphList;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.time.LocalTime;

import static java.lang.Math.ceil;

public class ClockWithGui extends JPanel {

    LocalTime time = LocalTime.now();

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // set the (0, 0) point to the center of frame
        g2d.translate((getWidth()/2), (getHeight() / 2));

        int radius = 130;
        int font_size = 12;

        g.setColor(new Color(169,169,169));
        g.fillOval(-radius, -radius, radius*2, radius*2);
        g.setColor(Color.blue);
        g2d.drawOval(-radius, -radius, radius*2, radius*2);
        g2d.setColor(Color.black);
        for (int i = 1; i < 13; i++) {
            AffineTransform at = new AffineTransform();
            at.rotate(2 * Math.PI / 12 * i);
            Point2D src = new Point2D.Float(0, -radius + font_size);
            Point2D trg = new Point2D.Float();

            String text = Integer.toString(i);
            FontRenderContext frc = new FontRenderContext(at,true,true);
            Font font = new Font("Tahoma", Font.PLAIN, font_size);
            int textWidth = (int)(font.getStringBounds(text, frc).getWidth());
            int textHeight = (int)(font.getStringBounds(text, frc).getHeight());

            at.transform(src, trg);
            int newX = 0;
            if ((int)trg.getX()>=0) {
                newX = (int)trg.getX() - (textWidth/2);
            } else {
                newX = (int)trg.getX() + (textWidth/2);
            }

            int newY = 0;
            if ((int)trg.getY()>0) {
                newY = (int)trg.getY() - (int)Math.ceil(textHeight/2);
            } else {
                newY = (int)trg.getY() + (int)Math.ceil(textHeight/2);
            }

            g2d.drawString(Integer.toString(i), newX, newY);
        }

        AffineTransform saveAT = g2d.getTransform();
        g2d.rotate(time.getHour() % 12 * 2 * Math.PI / 12);
        g2d.drawLine(0, 0, 0, -radius/2);
        g2d.setTransform(saveAT);

        saveAT = g2d.getTransform();
        g2d.rotate(time.getMinute() % 60 * 2 * Math.PI / 60);
        g2d.drawLine(0, 0, 0, (int)(-0.8 * radius));
        g2d.setTransform(saveAT);

        g2d.setColor(Color.red);
        saveAT = g2d.getTransform();
        g2d.rotate(time.getSecond() % 60 * 2 * Math.PI / 60);
        g2d.drawLine(0, 0, 0, (int)(-0.9 * radius));
        g2d.setTransform(saveAT);
    }

    class ClockThread extends Thread {
        @Override
        public void run() {
            while(true) {
                time = LocalTime.now();
                System.out.printf("%02d:%02d:%02d\n", time.getHour(), time.getMinute(), time.getSecond());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                repaint();
            }
        }
    }

    public ClockWithGui() {
        new ClockThread().start();
        setOpaque(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock With GUI");
        frame.setContentPane(new ClockWithGui());
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}