package com.Sarry_98.components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.Sarry_98.CustomButtonUI;

public class TextButton extends JButton{
    
    public TextButton(String str) {
        super(str);
        initUI();
        setUI(new CustomButtonUI());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);

        if (!model.isEnabled()) {
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g.getFontMetrics();
            String text = getText();
            int textX = (getWidth() - fm.stringWidth(text)) / 2;
            int textY = (getHeight() + fm.getAscent()) / 2 - 4;

            // Draw shadow text
            g2d.setColor(Color.WHITE);
            g2d.drawString(text, textX + 1, textY + 1);

            // Draw original text
            g2d.setColor(new Color(120, 120, 120));
            g2d.drawString(text, textX, textY);

            g2d.dispose();
        }
    }

    private void initUI() {
        setBackground(new Color(195, 195, 195));
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setFont(WindowFrame.textFont.deriveFont(Font.PLAIN, 14f));

        Color highlight = Color.WHITE;
        Color shadow = Color.BLACK;
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
            BorderFactory.createEmptyBorder(2, 20, 2, 20)
        ));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED, highlight, shadow),
                            BorderFactory.createEmptyBorder(2, 20, 2, 20)
                    ));
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                            BorderFactory.createEmptyBorder(2, 20, 2, 20)
                    ));
                }
            }
        });
    }
}
