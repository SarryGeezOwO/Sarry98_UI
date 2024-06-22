package com.example.components;

import com.example.MultiColorBorder;
import com.example.Vector2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GroupPanel extends JPanel {

    private String label;
    public GroupPanel(Vector2 size) {
        setPreferredSize(new Dimension(size.x, size.y));
        setLayout(new BorderLayout());
        initPanel();
        label = "";
    }
    public GroupPanel(Vector2 size, String label) {
        setPreferredSize(new Dimension(size.x, size.y));
        setLayout(new BorderLayout());
        initPanel();
        this.label = label;
    }



    public GroupPanel(Vector2 size, Panel.PanelType type) {
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
            case Border -> setLayout(new BorderLayout());
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
    }
    public GroupPanel(Vector2 size, String label, Panel.PanelType type) {
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
            case Border -> setLayout(new BorderLayout());
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
        this.label = label;
    }



    public GroupPanel(Vector2 size, Panel.PanelType type, Vector2 gap) {
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, gap.x, gap.y));
            case Border -> setLayout(new BorderLayout(gap.x, gap.y));
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
    }
    public GroupPanel(Vector2 size, String label, Panel.PanelType type, Vector2 gap) {
        setPreferredSize(new Dimension(size.x, size.y));
        switch (type) {
            case Flow -> setLayout(new FlowLayout(FlowLayout.LEADING, gap.x, gap.y));
            case Border -> setLayout(new BorderLayout(gap.x, gap.y));
            case BoxX -> setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            case BoxY -> setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        initPanel();
        this.label = label;
    }



    public void setLabel(String label) {
        this.label = label;
        initPanel();
        revalidate();
        repaint();
    }

    public String getLabel() {
        return label;
    }

    private void initPanel() {
        setBackground(new Color(195, 195, 195));

        Color highlight = Color.WHITE;
        Color shadow = Color.GRAY;
        TitledBorder border = new TitledBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        new MultiColorBorder(shadow, shadow, highlight, highlight, 1),
                        new MultiColorBorder(highlight, highlight, shadow, shadow, 1)
                ),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ), " " + label + " ");
        border.setTitleFont(WindowFrame.textFont.deriveFont(13f));
        border.setTitleColor(Color.BLACK);
        setBorder(BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(0, 6, 0, 6)
        ));
    }

}
