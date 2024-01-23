package src.utils;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class BackgroundPanel extends JComponent {
    private Image backgroundImage;

    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}