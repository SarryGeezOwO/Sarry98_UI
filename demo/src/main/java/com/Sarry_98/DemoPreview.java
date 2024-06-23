package com.Sarry_98;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.Sarry_98.components.*;
import com.Sarry_98.components.Checkbox;
import com.Sarry_98.components.Panel;

public class DemoPreview extends WindowFrame{

    public DemoPreview() {
        super("SarryG_98 Components", new Vector2(945, 470), FrameState.CLOSED, true);

        /* TODO: Unimplemented UIs
            1. TextField
            2. TextArea
            3. Status bar
            4. Slider
            5. Dropdown
            6. TableView
            7. TreView
         */

        // ================================================ Buttons Preview ========================================= //
        Panel buttonsPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel btnLabel = new JLabel("Buttons : ( Text or Image ) ");
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
        JLabel optionsLabel = new JLabel("Options : ( Vertical ------------ Horizontal )  ");
        optionsLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        optionsLabel.setForeground(Color.BLACK);

        GroupPanel optionGroup1 = new GroupPanel(new Vector2(160, 125), "Food preference", Panel.PanelType.Flow);
        OptionButtonMenu menu = new OptionButtonMenu(true, "Pizza", "Sushi", "Hotdog", "Donut");
        menu.setSelectedOption(2);
        menu.getOptions()[3].setEnabled(false);
        menu.getOptions()[2].setEnabled(false);
        optionGroup1.add(menu);

        Panel optionGroup2 = new Panel(new Vector2(202, 65), new Vector2(10, 5), Panel.PanelType.Flow);
        OptionButtonMenu menu2 = new OptionButtonMenu(false, "Yes", "No", "Maybe");
        menu2.setSelectedOption(0);
        menu2.getOptions()[2].setEnabled(false);
        JLabel labelGroup2 = new JLabel("Is your day going good? :");
        labelGroup2.setFont(textFont.deriveFont(Font.PLAIN, 16f));
        labelGroup2.setForeground(Color.BLACK);
        optionGroup2.add(labelGroup2);
        optionGroup2.add(menu2);

        JLabel sadNotice = new JLabel("Why? :(");
        sadNotice.setBorder(new EmptyBorder(10, 0, 0, 0));
        sadNotice.setFont(textFont.deriveFont(Font.BOLD, 12f));
        sadNotice.setForeground(Color.BLACK);
        menu2.addOptionMenuListener(selectedButton -> {
            if(selectedButton == menu2.getOptions()[1]) {
                optionsPanel.remove(optionGroup2);
                optionGroup2.setPreferredSize(new Dimension(202, 100));
                optionGroup2.add(sadNotice);
                optionsPanel.add(optionGroup2);
                revalidate();
                repaint();
            }else {
                optionsPanel.remove(optionGroup2);
                optionGroup2.remove(sadNotice);
                optionGroup2.setPreferredSize(new Dimension(202, 65));
                optionsPanel.add(optionGroup2);
                revalidate();
                repaint();
            }
        });

        optionsPanel.add(optionsLabel);
        optionsPanel.add(Box.createRigidArea(new Dimension(4000, 10)));
        optionsPanel.add(optionGroup1);
        optionsPanel.add(Box.createRigidArea(new Dimension(20, 10)));
        optionsPanel.add(optionGroup2);

        // ================================================ Group Panel Preview ========================================= //
        Panel groupPaneList = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel groupPaneListLabel = new JLabel("Group Panel :  ");
        groupPaneListLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        groupPaneListLabel.setForeground(Color.BLACK);

        GroupPanel groupPanel = new GroupPanel(new Vector2(203, 145), Panel.PanelType.Flow);
        groupPanel.setLabel("GroupPanel 1");
        GroupPanel groupPanel2 = new GroupPanel(new Vector2(170, 60), Panel.PanelType.Flow);

        Checkbox sample = new Checkbox("show label");
        sample.addCheckboxListener(new CheckboxListener() {
            @Override
            public void onSelect() {
                groupPanel2.setLabel("Label");
            }

            @Override
            public void onDeselect() {
                groupPanel2.setLabel("");
            }
        });
        Checkbox box = new Checkbox("show content example");

        JLabel text = new JLabel("...Checkbox selected!");
        text.setPreferredSize(new Dimension(300, 25));
        text.setVerticalAlignment(JLabel.BOTTOM);
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

        groupPanel.add(sample);
        groupPanel.add(box);
        groupPanel.add(Box.createRigidArea(new Dimension(200, 2)));
        groupPanel.add(groupPanel2);

        groupPaneList.add(groupPaneListLabel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 5)));
        groupPaneList.add(groupPanel);
        groupPaneList.add(Box.createRigidArea(new Dimension(4000, 10)));

        // ================================================ TextInputs Preview ========================================= //
        Panel textFieldPanel = new Panel(new Vector2(440, 200), new Vector2(10, 10), Panel.PanelType.Flow);
        JLabel textFieldLabel = new JLabel("TextField :");
        textFieldLabel.setFont(new Font("MS Sans Serif", Font.PLAIN, 16));
        textFieldLabel.setForeground(Color.BLACK);

        textFieldPanel.add(textFieldLabel);
        textFieldPanel.add(Box.createRigidArea(new Dimension(4000, 5)));

        // ==================== Container ==================== //
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(440, 670));
        container.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        container.setOpaque(false);

        // Add All preview panels
        container.add(buttonsPanel);
        container.add(checkBoxPanel);
        container.add(optionsPanel);
        container.add(groupPaneList);
        container.add(textFieldPanel);
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
        SwingUtilities.invokeLater(DemoPreview::new);
        // Nothing Happened bro...
    }
}
