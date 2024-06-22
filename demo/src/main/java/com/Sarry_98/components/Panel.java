package com.Sarry_98.components;

import com.Sarry_98.Vector2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Panel extends JPanel {

    private Vector2 padding;

    public enum PanelType {
        Flow, Border, BoxX, BoxY
    }

    public Panel(Vector2 size, Vector2 padding) {
        this.padding = padding;
        setPreferredSize(new Dimension(size.x, size.y));
        setLayout(new BorderLayout());
        initPanel();
    }

    public Panel(Vector2 size, Vector2 padding, PanelType type) {
        this.padding = padding;
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
            case Border -> setLayout(new BorderLayout());
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
    }

    public Panel(Vector2 size, Vector2 padding, PanelType type, Vector2 gap) {
        this.padding = padding;
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, gap.x, gap.y));
            case Border -> setLayout(new BorderLayout(gap.x, gap.y));
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
    }

    private void initPanel() {
        setBackground(new Color(195, 195, 195));

        Color highlight = Color.LIGHT_GRAY;
        Color accentlight = Color.WHITE;
        Color accentShadow = Color.DARK_GRAY;
        Color shadow = Color.BLACK;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
                        BorderFactory.createBevelBorder(BevelBorder.RAISED, accentlight, accentShadow)
                ),
                BorderFactory.createEmptyBorder(padding.y, padding.x, padding.y, padding.x)
        ));
    }
}
