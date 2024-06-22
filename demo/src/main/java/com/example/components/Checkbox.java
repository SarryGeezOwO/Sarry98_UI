package com.example.components;

import com.example.AssetHandler;
import com.example.Vector2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Checkbox extends JPanel {

    public boolean isSelected = false;
    public boolean isEnabled = true;

    private final JButton btn;

    private final ImageIcon checkIcon;
    private final ImageIcon checkIconDisabled;

    public Checkbox(String str) {
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setOpaque(false);

        AssetHandler handler = new AssetHandler();
        checkIcon = handler.resizeIcon("/images/check_pixel.png", new Vector2(10, 10));
        checkIconDisabled = handler.resizeIcon("/images/check_disabled_pixel.png", new Vector2(10, 10));

        btn = new JButton() {
            @Override
            public void paint(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paint(g);
            }
        };
        btn.setContentAreaFilled(false);
        btn.setBackground(Color.WHITE);
        btn.addActionListener(e -> actionPerform());
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(isEnabled) btn.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btn.setBackground(Color.WHITE);
            }
        });
        btn.setPreferredSize(new Dimension(18, 18));

        Color highlight = Color.WHITE;
        Color shadow = Color.BLACK;
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED, shadow, highlight),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));

        JLabel label = new JLabel(str) {
            @Override
            public void paint(Graphics g) {
                if (!isEnabled) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    FontMetrics fm = g2d.getFontMetrics();
                    String text = getText();
                    g2d.setFont(getFont());
                    int textX = (getWidth() - fm.stringWidth(text)) / 2;
                    int textY = (getHeight() + fm.getAscent()) / 2 - 4;

                    // Draw shadow text
                    g2d.setColor(new Color(240, 240, 240));
                    g2d.drawString(text, textX + 2, textY + 2);

                    g2d.dispose();
                    setForeground(new Color(120, 120, 120));
                }
                super.paint(g);
            }
        };
        label.setFont(WindowFrame.textFont.deriveFont(Font.PLAIN, 15f));
        label.setForeground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actionPerform();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isEnabled) btn.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btn.setBackground(Color.WHITE);
            }
        });

        add(btn);
        add(Box.createRigidArea(new Dimension(5, 5)));
        add(label);
    }

    private void actionPerform() {
        if(isEnabled) {
            setSelected(!isSelected);
        }
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        btn.setIcon((isSelected ? (isEnabled ?  checkIcon :  checkIconDisabled) : null));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btn.setEnabled(enabled);
        isEnabled = enabled;
    }
}
