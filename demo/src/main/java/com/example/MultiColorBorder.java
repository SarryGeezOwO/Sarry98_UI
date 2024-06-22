package com.example;

import javax.swing.border.Border;
import java.awt.*;

public class MultiColorBorder implements Border {
    private final Color topColor;
    private final Color leftColor;
    private final Color bottomColor;
    private final Color rightColor;
    private final int thickness;

    public MultiColorBorder(Color topColor, Color leftColor, Color bottomColor, Color rightColor, int thickness) {
        this.topColor = topColor;
        this.leftColor = leftColor;
        this.bottomColor = bottomColor;
        this.rightColor = rightColor;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(topColor);
        g.fillRect(x, y, width, thickness);

        g.setColor(leftColor);
        g.fillRect(x, y, thickness, height);

        g.setColor(bottomColor);
        g.fillRect(x, y + height - thickness, width, thickness);

        g.setColor(rightColor);
        g.fillRect(x + width - thickness, y, thickness, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

