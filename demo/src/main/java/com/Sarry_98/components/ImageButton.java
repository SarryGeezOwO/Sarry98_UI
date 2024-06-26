package com.Sarry_98.components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import com.Sarry_98.CustomButtonUI;

import java.awt.*;
import java.awt.event.*;

public class ImageButton extends JButton {

    public ImageButton(ImageIcon icn) {
        super();
        setIcon(icn);
        initUI();
        setUI(new CustomButtonUI());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    private void initUI() {
        setBackground(new Color(195, 195, 195));
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setContentAreaFilled(false);


        Color highlight = Color.WHITE;
        Color shadow = Color.BLACK;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED, highlight, shadow),
                            BorderFactory.createEmptyBorder(2, 2, 2, 2)
                    ));
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                            BorderFactory.createEmptyBorder(2, 2, 2, 2)
                    ));
                }
            }
        });
    }
    
}
