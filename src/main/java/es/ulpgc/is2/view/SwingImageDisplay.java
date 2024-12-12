package es.ulpgc.is2.view;

import es.ulpgc.is2.model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    private BufferedImage bitmap;

    @Override
    public void show(Image image) {
        this.image = image;
        this.bitmap = load(image.name());
        this.repaint();
    }

    private BufferedImage load(byte[] name) {
        try {
            return ImageIO.read(new ByteArrayInputStream(name));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image image() {
        return image;
    }

    public  void clean(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void paint(Graphics g){
        clean(g);
        g.drawImage(bitmap, calculateViewport().x(), calculateViewport().y(), calculateViewport().width(),
                calculateViewport().height(), this);
    }

    private ViewPort calculateViewport() {
        return ViewPort.ofSize(this.getWidth(), this.getHeight())
                .fit(bitmap.getWidth(), bitmap.getHeight());
    }

}
