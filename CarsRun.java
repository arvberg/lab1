import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CarsRun {

    public static void main(String[] args) {
        Cars volvo = new Volvo240();
        volvo.setDirection("up");

        Cars saab = new Saab95();
        saab.setDirection("up");

        JFrame frame = new JFrame("Car Control");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel(volvo, saab);
        frame.add(carPanel);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        volvo.gas(1);
                        break;
                    case KeyEvent.VK_S:
                        volvo.brake(1);
                        break;
                    case KeyEvent.VK_A:
                        volvo.turnRight();
                        break;
                    case KeyEvent.VK_D:
                        volvo.turnLeft();
                        break;
                    case KeyEvent.VK_UP:
                        saab.gas(1);
                        break;
                    case KeyEvent.VK_DOWN:
                        saab.brake(1);
                        break;
                    case KeyEvent.VK_LEFT:
                        saab.turnRight();
                        ;
                        break;
                    case KeyEvent.VK_RIGHT:
                        saab.turnLeft();
                        break;
                    case KeyEvent.VK_SHIFT:
                        saab.setTurboOn();
                        break;
                    case KeyEvent.VK_CONTROL:
                        saab.setTurboOff();
                        break;
                    case KeyEvent.VK_SPACE:
                        volvo.stopEngine();
                        saab.stopEngine();
                        volvo.setPosition(new Point(0, 0));
                        saab.setPosition(new Point(0, 0));
                        break;
                }
            }
        });

        Timer timer = new Timer(16, e -> {
            volvo.move();
            saab.move();
            carPanel.repaint();
        });
        timer.start();
    }
}

class CarPanel extends JPanel {

    private Cars volvo;
    private Cars saab;

    public CarPanel(Cars volvo, Cars saab) {
        this.volvo = volvo;
        this.saab = saab;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCar(g, volvo, Color.BLUE);
        drawCar(g, saab, Color.RED);
    }

    private void drawCar(Graphics g, Cars car, Color color) {
        g.setColor(color);
        int x = car.getX();
        int y = car.getY();
        int width = 50;
        int height = 30;

        switch (car.getDirection()) {
            case "up":
                g.fillRect(x, y, height, width);
                g.setColor(Color.BLACK);
                g.fillRect(x + height / 2 - 5, y + width - 5, 10, 5); // Front of the car
                break;
            case "down":
                g.fillRect(x, y, height, width);
                g.setColor(Color.BLACK);
                g.fillRect(x + height / 2 - 5, y, 10, 5); // Front of the car
                break;
            case "left":
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.fillRect(x, y + height / 2 - 5, 5, 10); // Front of the car
                break;
            case "right":
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.fillRect(x + width - 5, y + height / 2 - 5, 5, 10); // Front of the car
                break;
        }
    }
}