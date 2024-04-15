package planetlanding.ui;

import planetlanding.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImagePanel extends JComponent {
    private static BufferedImage image = null;

    //Background Image Panel
    static {
        try {
            image = ImageIO.read(Objects.requireNonNull(Main.class.getResource("/modulecockpit_02.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, 1500, 1000, this);
    }
}