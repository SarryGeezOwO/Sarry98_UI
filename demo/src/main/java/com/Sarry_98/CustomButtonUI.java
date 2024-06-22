package com.Sarry_98;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButtonUI extends BasicButtonUI {
    private boolean pressed = false;

    @Override
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        if (pressed) {
            textRect.translate(0, 1); // Move text down by 1 pixel
        }
        super.paintText(g, b, textRect, text);
    }

    @Override
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        if (pressed) {
            iconRect.translate(0, 1); // Move Icon down by 1 pixel
        }
        super.paintIcon(g, c, iconRect);
    }

    @Override
    protected void installListeners(AbstractButton b) {
        super.installListeners(b);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                b.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                b.repaint();
            }
        });
    }
}