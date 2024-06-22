package com.example;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.components.*;
import com.example.components.Checkbox;
import com.example.components.Panel;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("SarryG_98 Components", new Vector2(500, 550), FrameState.CLOSED, true);

        Panel buttonsPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel btnLabel = new JLabel("Buttons :  ");
        btnLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        btnLabel.setForeground(Color.BLACK);

        TextButton btn = new TextButton("Default");
        TextButton btnDisabled = new TextButton("Disabled");
        btnDisabled.setEnabled(false);
        ImageButton imgBtn = new ImageButton(scaledIcon("demo/src/main/resources/images/close.png", new Vector2(20, 20)));

        buttonsPanel.add(btnLabel);
        buttonsPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        buttonsPanel.add(btn);
        buttonsPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        buttonsPanel.add(btnDisabled);
        buttonsPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        buttonsPanel.add(imgBtn);

        Panel checkBoxPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel checkBoxLabel = new JLabel("Checkbox :  ");
        checkBoxLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        checkBoxLabel.setForeground(Color.BLACK);

        Checkbox checkbox = new Checkbox("I am a checkbox!");

        Checkbox checkboxdisabled = new Checkbox("disabled checkbox");
        checkboxdisabled.setEnabled(false);

        Checkbox checkboxdisabledChecked = new Checkbox("disabled checkbox but checked");
        checkboxdisabledChecked.setEnabled(false);
        checkboxdisabledChecked.setSelected(true);

        checkBoxPanel.add(checkBoxLabel);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkbox);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkboxdisabled);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkboxdisabledChecked);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));

        Panel optionsPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel optionsLabel = new JLabel("Options :  ");
        optionsLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        optionsLabel.setForeground(Color.BLACK);

        optionsPanel.add(optionsLabel);
        optionsLabel.add(Box.createRigidArea(new Dimension(4000, 10)));

        Panel groupPaneList = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel groupPaneListLabel = new JLabel("Group Panel :  ");
        groupPaneListLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        groupPaneListLabel.setForeground(Color.BLACK);

        GroupPanel groupPanel = new GroupPanel(new Vector2(200, 140), Panel.PanelType.Flow);
        groupPanel.setLabel("GroupPanel 1");
        GroupPanel groupPanel2 = new GroupPanel(new Vector2(170, 45));
        groupPanel2.setLabel("GroupPanel 2");

        TextButton sample = new TextButton("Hello world!");
        sample.setPreferredSize(new Dimension(170, 25));
        Checkbox box = new Checkbox("I am a checkbox!");

        groupPanel.add(box);
        groupPanel.add(sample);
        groupPanel.add(Box.createRigidArea(new Dimension(200, 5)));
        groupPanel.add(groupPanel2);

        groupPaneList.add(groupPaneListLabel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 10)));
        groupPaneList.add(groupPanel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 10)));


        JPanel container = new JPanel();
        int n = 4;
        container.setPreferredSize(new Dimension(440, (200*n) + (5 * (n+1) + 3 )));
        container.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        container.setOpaque(false);

        container.add(buttonsPanel);
        container.add(checkBoxPanel);
        container.add(optionsPanel);
        container.add(groupPaneList);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        ScrollPanel scrollPane = new ScrollPanel(container, ScrollPanel.ScrollType.BOTH);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
