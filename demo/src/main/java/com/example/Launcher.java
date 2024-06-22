package com.example;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.components.*;
import com.example.components.Checkbox;
import com.example.components.Panel;

public class Launcher extends WindowFrame{

    public Launcher() {
        super("SarryG_98 Components", new Vector2(945, 470), FrameState.CLOSED, true);

        // ================================================ Buttons Preview ========================================= //
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

        // ================================================ Checkbox Preview ========================================= //
        Panel checkBoxPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel checkBoxLabel = new JLabel("Checkbox :  ");
        checkBoxLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        checkBoxLabel.setForeground(Color.BLACK);

        Checkbox checkbox = new Checkbox("I am a checkbox!");

        Checkbox checkboxDisabled = new Checkbox("disabled checkbox");
        checkboxDisabled.setEnabled(false);

        Checkbox checkboxDisabledChecked = new Checkbox("disabled checkbox but checked");
        checkboxDisabledChecked.setEnabled(false);
        checkboxDisabledChecked.setSelected(true);

        checkBoxPanel.add(checkBoxLabel);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkbox);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkboxDisabled);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        checkBoxPanel.add(checkboxDisabledChecked);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(4000, 10)));

        // ================================================ Options button Preview ========================================= //
        Panel optionsPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel optionsLabel = new JLabel("Options :  ");
        optionsLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        optionsLabel.setForeground(Color.BLACK);

        optionsPanel.add(optionsLabel);
        optionsLabel.add(Box.createRigidArea(new Dimension(4000, 10)));

        // ================================================ Group Panel Preview ========================================= //
        Panel groupPaneList = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel groupPaneListLabel = new JLabel("Group Panel :  ");
        groupPaneListLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        groupPaneListLabel.setForeground(Color.BLACK);

        GroupPanel groupPanel = new GroupPanel(new Vector2(200, 140), Panel.PanelType.Flow);
        groupPanel.setLabel("GroupPanel 1");
        GroupPanel groupPanel2 = new GroupPanel(new Vector2(170, 45));

        TextButton sample = new TextButton("Hello world!");
        sample.setPreferredSize(new Dimension(170, 25));
        Checkbox box = new Checkbox("I am a checkbox!");

        JLabel text = new JLabel("...Checkbox selected!");
        text.setFont(textFont.deriveFont(14f));
        text.setForeground(Color.BLACK);
        box.addCheckboxListener(new CheckboxListener() {
            @Override
            public void onSelect() {
                groupPanel2.add(text);
                revalidate();
                repaint();
            }

            @Override
            public void onDeselect() {
                groupPanel2.remove(text);
                revalidate();
                repaint();
            }
        });

        groupPanel.add(box);
        groupPanel.add(sample);
        groupPanel.add(Box.createRigidArea(new Dimension(200, 7)));
        groupPanel.add(groupPanel2);

        groupPaneList.add(groupPaneListLabel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 10)));
        groupPaneList.add(groupPanel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 10)));



        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(440, 470));
        container.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        container.setOpaque(false);

        // Add All preview panels
        container.add(buttonsPanel);
        container.add(checkBoxPanel);
        container.add(optionsPanel);
        container.add(groupPaneList);
        container.add(Box.createRigidArea(new Dimension(5000, 10)));
        JLabel notice = new JLabel("-- Created by SarryGeezOwO, Inspired by 98.css");
        notice.setFont(defaultFont.deriveFont(18f));
        notice.setForeground(Color.BLACK);
        container.add(notice);

        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        ScrollPanel scrollPane = new ScrollPanel(container, ScrollPanel.ScrollType.BOTH);        // ======== Scroll Panel preview ======== //

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Launcher::new);
    }
}
