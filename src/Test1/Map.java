package Test1;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {
    private BufferedImage mapImage;
    private boolean[][] walkable;
    private int width;
    private int height;

    public Map(String mapFilePath) {
        loadImage(mapFilePath);
        initializeWalkable();
    }

    private void loadImage(String filePath) {
        try {
            mapImage = ImageIO.read(new File(filePath));
            width = mapImage.getWidth();
            height = mapImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeWalkable() {
        walkable = new boolean[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = mapImage.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                walkable[x][y] = alpha != 0;
            }
        }
    }

    public void draw(Graphics g) {
        if (mapImage != null) {
            g.drawImage(mapImage, 0, 0, null);
        }
    }

    public boolean canMoveTo(int x, int y, int size) {
        if (x < 0 || y < 0 || x + size > width || y + size > height) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x + i < width && y + j < height && !walkable[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
