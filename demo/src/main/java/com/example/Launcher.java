package com.example;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.example.components.*;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("NotaCaudex", new Vector2(600, 700), FrameState.CLOSED, true);

        JLabel labelBtn = new JLabel("Example of Button");
        TextButton btn = new TextButton("Sample");

        JLabel labelBtnDisable = new JLabel("Example of Disabled Button");
        TextButton btn2 = new TextButton("Hello...");
        btn2.setEnabled(false);

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(20, 20, 20, 20));
        p.setOpaque(false);

        p.add(labelBtn);
        p.add(btn);
        p.add(Box.createRigidArea(new Dimension(500, 30)));
        p.add(labelBtnDisable);
        p.add(btn2);
        mainPanel.add(p, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
