import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BouncingBallsPanel extends JPanel {
    static class Ball {
        int x;
        int y;
        double vx;
        double vy;
        Color color;

        // 630 and 690 - values selected experimentally
        public void process() {
            if (x + vx < 0 || x + 20 + vx > 690) {
                vx *= -1;
            }
            if (y + vy < 0 || y + 20 + vy > 630) {
                vy *= -1;
            }
            x += vx;
            y += vy;
        }

        public Ball(int x, int y, double vx, double vy, Color color) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.color = color;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.setColor(b.color);
            g2.fillOval(b.x, b.y, 20, 20);
        }
    }

    // the simplest method of detecting collisions, it should be done better...
    void collision(Ball b) {
        for (int i = 0; i < balls.size(); i++) {
            Ball b2 = balls.get(i);
            if (b2 != b) {
                int dx = Math.abs(b2.x - b.x);
                int dy = Math.abs(b2.y - b.y);
                int distSqr = (dx * dx) + (dy * dy);
                if (distSqr < 160) {
                    b.vx *= -1;
                    b.vy *= -1;
                    b2.vx *= -1;
                    b2.vy *= -1;
                }
            }
        }
    }

    List<Ball> balls = new ArrayList<>();

    class AnimationThread extends Thread {
        boolean suspend = true;

        public void pause() {
            suspend = true;
        }

        public synchronized void wakeUp() {
            suspend = false;
            notify();
        }

        public void run() {
            while (true) {
                for (Ball ball : balls) {
                    ball.process();
                    collision(ball);
                }
                repaint();

                synchronized (this) {
                    try {
                        if (suspend) {
                            System.out.println("suspending");
                            wait();
                        }
                    } catch (InterruptedException e) {
                    }
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private AnimationThread workingThread = new AnimationThread();
    int height;
    int width;

    BouncingBallsPanel(int width, int height) {
        this.height = height;
        this.width = width;
        workingThread.start();
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
    }

    // wakeUp() and pasue() methods were added to start and pause animation, without them it was hard to manage threads
    void onStart() {
        System.out.println("Start or resume animation thread");
        workingThread.wakeUp();
    }

    void onStop() {
        System.out.println("Suspend animation thread");
        workingThread.pause();
    }

    void onPlus() {
        Random r = new Random();
        // To randomize balls colors, otherwise all balls would be the same
        Color ballColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        // balls speed will be from -10 to 10
        balls.add(new Ball(50 + r.nextInt(width - 100), 50 + r.nextInt(height - 100), r.nextInt(20) - 10, r.nextInt(20) - 10, ballColor));
    }

    void onMinus() {
        // if mot empty, remove the last added ball
        if (!balls.isEmpty()) {
            balls.remove(balls.size() - 1);
        }
    }
}
