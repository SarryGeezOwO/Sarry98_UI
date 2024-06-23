package com.Sarry_98.components;

import com.Sarry_98.AssetHandler;
import com.Sarry_98.CheckboxListener;
import com.Sarry_98.Vector2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Checkbox extends JPanel {

    public boolean isSelected = false;
    public boolean isEnabled = true;

    private JButton btn;

    private ImageIcon checkIcon;
    private ImageIcon checkDisabledIcon;
    private String text;
    private CheckboxListener checkboxListener;

    public Checkbox(String text) {
        this.text = text;
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        setBorder(new EmptyBorder(2, 5, 2, 5));
        setOpaque(false);
        initUI();

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
                if(isEnabled) btn.setBackground(Color.WHITE);
            }
        });
    }

    private void initUI() {
        AssetHandler handler = new AssetHandler();
        checkIcon = handler.resizeIcon("/images/check_pixel.png", new Vector2(9, 9));
        checkDisabledIcon = handler.resizeIcon("/images/check_disabled_pixel.png", new Vector2(8, 8));

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
                if(isEnabled) btn.setBackground(Color.WHITE);
            }
        });
        btn.setPreferredSize(new Dimension(18, 18));

        Color highlight = Color.WHITE;
        Color accentlight = Color.LIGHT_GRAY;
        Color shadow = Color.BLACK;
        Color accentShadow = new Color(111, 111, 111);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createBevelBorder(BevelBorder.RAISED, accentShadow, highlight),
                        BorderFactory.createBevelBorder(BevelBorder.RAISED, shadow, accentlight)
                ),
                BorderFactory.createEmptyBorder(3, 3, 3, 3)
        ));

        JLabel label = new JLabel(text) {
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
        label.setFont(WindowFrame.textFont.deriveFont(Font.PLAIN, 14f));
        label.setForeground(Color.BLACK);

        add(btn);
        add(Box.createRigidArea(new Dimension(5, 5)));
        add(label);
    }

    private void actionPerform() {
        if(isEnabled)
            setSelected(!isSelected);

        if(checkboxListener != null)
            checkboxPerform();
    }

    private void refreshUI() {
        removeAll();
        initUI();
    }

    public void addCheckboxListener(CheckboxListener checkboxListener) {
        this.checkboxListener = checkboxListener;
    }

    private void checkboxPerform() {
        if(isSelected) checkboxListener.onSelect();
        else checkboxListener.onDeselect();
    }

    public void setText(String text) {
        this.text = text;
        refreshUI();
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        btn.setIcon((isSelected ? (isEnabled ? checkIcon : checkDisabledIcon) : null));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btn.setEnabled(enabled);
        isEnabled = enabled;
        if(!isEnabled) btn.setBackground(new Color(140, 140, 140));
    }
}
