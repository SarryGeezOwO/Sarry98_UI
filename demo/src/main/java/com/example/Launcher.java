package com.example;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.components.*;
import com.example.components.Panel;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("SarryG_98 Components", new Vector2(500, 550), FrameState.CLOSED, true);

        Panel buttonsPanel = new Panel(new Vector2(500, 160), new Vector2(10, 10), Panel.PanelType.BoxY);
        JLabel btnLabel = new JLabel("Buttons :  ");
        btnLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        btnLabel.setForeground(Color.BLACK);

        TextButton btn = new TextButton("Default");
        TextButton btnDisabled = new TextButton("Disabled");
        btnDisabled.setEnabled(false);
        ImageButton imgBtn = new ImageButton(scaledIcon("demo/src/main/resources/images/close.png", new Vector2(20, 20)));

        buttonsPanel.add(btnLabel);
        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(btn);
        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(btnDisabled);
        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(imgBtn);

        Panel checkBoxPanel = new Panel(new Vector2(500, 400), new Vector2(10, 10), Panel.PanelType.BoxY);
        JLabel checkBoxLabel = new JLabel("Checkbox :  ");
        checkBoxLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        checkBoxLabel.setForeground(Color.BLACK);

        for(int i = 0; i < 10; i++) {
            checkBoxPanel.add(new JLabel("bruh"));
            checkBoxPanel.add(Box.createVerticalStrut(5));
        }

        Panel optionsPanel = new Panel(new Vector2(500, 400), new Vector2(10, 10), Panel.PanelType.BoxY);
        JLabel optionsLabel = new JLabel("Checkbox :  ");
        optionsLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        optionsLabel.setForeground(Color.BLACK);

        for(int i = 0; i < 10; i++) {
            optionsPanel.add(new JLabel("OPtions"));
            optionsPanel.add(Box.createVerticalStrut(5));
        }


        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setOpaque(false);

        container.add(buttonsPanel);
        container.add(checkBoxPanel);
        container.add(optionsPanel);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        ScrollPanel scrollPane = new ScrollPanel(container, ScrollPanel.ScrollType.BOTH);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
