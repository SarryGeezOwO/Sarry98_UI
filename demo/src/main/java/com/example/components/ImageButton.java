package com.example.components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

import com.example.WindowFrame;

public class ImageButton extends JButton {

    public ImageButton(ImageIcon icn) {
        super();
        setIcon(icn);
        initUI();
    }

    private void initUI() {
        setBackground(new Color(170, 170, 180));
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setFont(WindowFrame.textFont.deriveFont(Font.PLAIN, 16f));

        Color highlight = Color.LIGHT_GRAY;
        Color accentlight = Color.WHITE;
        Color accentShadow = Color.DARK_GRAY;
        Color shadow = Color.BLACK;
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                BorderFactory.createBevelBorder(BevelBorder.RAISED, accentlight, accentShadow)
            ),
            BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED, highlight, shadow),
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED, accentlight, accentShadow)
                        ),
                        BorderFactory.createEmptyBorder(2, 2, 2, 2)
                    ));
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(isEnabled()) {
                    setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, accentlight, accentShadow)
                        ),
                        BorderFactory.createEmptyBorder(2, 2, 2, 2)
                    ));
                }
            }
        });
    }
    
}
