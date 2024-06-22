package com.Sarry_98.components;

import com.Sarry_98.AssetHandler;
import com.Sarry_98.CheckboxListener;
import com.Sarry_98.Vector2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionButton extends JPanel {

    public boolean isSelected = false;
    public boolean isEnabled = true;

    private final ImageIcon normalIcon;
    private final ImageIcon checkedIcon;
    private final ImageIcon pressedIcon;
    private final ImageIcon pressedCheckedIcon;

    private JButton btn;
    private String text;
    private CheckboxListener checkboxListener;

    public OptionButton(String text) {
        this.text = text;
        setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        setBorder(new EmptyBorder(2, 5, 2, 5));
        setOpaque(false);

        AssetHandler handler = new AssetHandler();
        normalIcon = handler.resizeIcon("/images/RadioButton.png", new Vector2(12, 12));
        checkedIcon = handler.resizeIcon("/images/RadioButton_Checked.png", new Vector2(12, 12));
        pressedIcon = handler.resizeIcon("/images/RadioButton_Pressed.png", new Vector2(12, 12));
        pressedCheckedIcon = handler.resizeIcon("/images/RadioButton_Pressed_Checked.png", new Vector2(12, 12));
        initUI();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actionPerform();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(isEnabled) {
                    btn.setIcon(pressedIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(isEnabled) {
                    if(isSelected) btn.setIcon(checkedIcon);
                    else btn.setIcon(normalIcon);
                }
            }
        });
    }

    private void initUI() {
        btn = new JButton();
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);

        btn.setDisabledIcon(pressedIcon);
        btn.setDisabledSelectedIcon(pressedCheckedIcon);

        btn.addActionListener(e -> actionPerform());
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(isEnabled) {
                    btn.setIcon(pressedIcon);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(isEnabled) {
                    if(isSelected) btn.setIcon(checkedIcon);
                    else btn.setIcon(normalIcon);
                }
            }
        });
        btn.setPreferredSize(new Dimension(18, 18));
        btn.setIcon(normalIcon);

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
        if(!isEnabled)
            return;
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

    public String getText() {
        return text;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        btn.setSelected(selected);
        btn.setIcon((isSelected ? (isEnabled ? checkedIcon : pressedCheckedIcon) : normalIcon));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        btn.setEnabled(enabled);
        isEnabled = enabled;
    }
}
