package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.example.components.*;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("SarryG_98 Components", new Vector2(400, 150), FrameState.CLOSED, true);

        JLabel labelBtn = new JLabel("Hello world!", JLabel.CENTER);
        labelBtn.setFont(textFont.deriveFont(Font.PLAIN, 18f));
        labelBtn.setForeground(Color.BLACK);

        JPanel bot = new JPanel();
        bot.setOpaque(false);
        TextButton btn = new TextButton("Okay");
        TextButton btn2 = new TextButton("Cancel");

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        bot.add(btn);
        bot.add(btn2);
        p.setBorder(new EmptyBorder(20, 20, 20, 20));
        p.setOpaque(false);

        p.add(labelBtn, BorderLayout.CENTER);
        p.add(bot, BorderLayout.SOUTH);
        mainPanel.add(p, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
