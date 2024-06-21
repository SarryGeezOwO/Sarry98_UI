package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.components.*;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("SarryG_98 Components", new Vector2(500, 550), FrameState.CLOSED, true);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        JLabel btnLabel = new JLabel("Buttons : ");
        btnLabel.setFont(textFont.deriveFont(16f));
        btnLabel.setForeground(Color.BLACK);

        TextButton btn = new TextButton("Default");
        TextButton btnDisabled = new TextButton("Disabled");
        btnDisabled.setEnabled(false);
        ImageButton imgBtn = new ImageButton(scaledIcon("demo/src/main/resources/images/close.png", new Vector2(20, 20)));

        buttonsPanel.add(btnLabel);
        buttonsPanel.add(btn);
        buttonsPanel.add(btnDisabled);
        buttonsPanel.add(imgBtn);

        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
