package com.Sarry_98;

import com.Sarry_98.components.ImageButton;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class OldScrollbarUI extends BasicScrollBarUI {

    private final Color thumbTopColor = new Color(230, 230, 230); // Top color of the bevel border
    private final Color thumbBottomColor = Color.BLACK; // Bottom color of the bevel border

    @Override
    protected void configureScrollBarColors() {
        thumbColor = new Color(195, 195, 195);
        trackColor = new Color(170, 170, 170);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(trackColor);
        g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        g2.dispose();
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int thumbWidth = thumbBounds.width;
        int thumbHeight = thumbBounds.height;

        // Top bevel
        g2.setColor(thumbTopColor);
        g2.drawLine(thumbBounds.x, thumbBounds.y, thumbBounds.x + thumbWidth - 1, thumbBounds.y);
        g2.drawLine(thumbBounds.x, thumbBounds.y, thumbBounds.x, thumbBounds.y + thumbHeight - 1);

        // Bottom bevel
        g2.setColor(thumbBottomColor);
        g2.drawLine(thumbBounds.x + 1, thumbBounds.y + thumbHeight - 1, thumbBounds.x + thumbWidth - 1, thumbBounds.y + thumbHeight - 1);
        g2.drawLine(thumbBounds.x + thumbWidth - 1, thumbBounds.y + 1, thumbBounds.x + thumbWidth - 1, thumbBounds.y + thumbHeight - 1);

        // Fill thumb with default color
        g2.setColor(thumbColor);
        g2.fillRect(thumbBounds.x + 1, thumbBounds.y + 1, thumbWidth - 2, thumbHeight - 2);

        g2.dispose();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton(scrollbar.getOrientation(), true);
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton(scrollbar.getOrientation(), false);
    }

    private JButton createZeroButton(int orientation, boolean isDecrease) {
        AssetHandler handler = new AssetHandler();
        ImageIcon up = handler.resizeIcon("/images/caret-up.png", new Vector2(16, 16));
        ImageIcon down = handler.resizeIcon("/images/caret-down.png", new Vector2(16, 16));
        ImageIcon left = handler.resizeIcon("/images/caret-left.png", new Vector2(16, 16));
        ImageIcon right = handler.resizeIcon("/images/caret-right.png", new Vector2(16, 16));

        ImageButton button = new ImageButton(null);
        button.setPreferredSize(new Dimension(16, 16));

        if (orientation == BasicScrollBarUI.VERTICAL) {
            if (isDecrease) {
                button.setIcon(up);
            } else {
                button.setIcon(down);
            }
        } else if (orientation == BasicScrollBarUI.HORIZONTAL) {
            if (isDecrease) {
                button.setIcon(left);
            } else {
                button.setIcon(right);
            }
        }
        return button;
    }
}
