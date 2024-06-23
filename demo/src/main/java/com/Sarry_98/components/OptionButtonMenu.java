package com.Sarry_98.components;

import com.Sarry_98.CheckboxListener;
import com.Sarry_98.OptionMenuListener;

import javax.swing.*;

public class OptionButtonMenu extends JPanel {

    private OptionButton[] options;
    private OptionButton selectedOption;
    private OptionMenuListener listener;

    public OptionButtonMenu(boolean isVertical, String ... options) {
        setOptions(options);
        setLayout(new BoxLayout(this, (isVertical ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS)));
        setOpaque(false);
        initMenu();
    }

    private void initMenu() {
        for(OptionButton btn : options) {
            btn.addCheckboxListener(new CheckboxListener() {
                @Override
                public void onSelect() {
                    setSelectedOption(btn.getText());
                }

                @Override
                public void onDeselect() {
                    setSelectedOption(null);
                }
            });
            add(btn);
        }
    }

    public void addOptionMenuListener(OptionMenuListener listener) {
        this.listener = listener;
    }

    private void optionListenerAction() {
        if(listener == null)
            return;

        listener.onSelectionChange(getSelectedOption());
    }

    public void setOptions(String[] ops) {
        OptionButton[] arr = new OptionButton[ops.length];
        int index = 0;

        for(String s : ops) {
            OptionButton btn = new OptionButton(s);
            arr[index] = btn;
            index++;
        }
        options = arr;
    }

    public OptionButton[] getOptions() {
        return options;
    }

    public OptionButton getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        for(OptionButton btn : options) {

            if(btn.getText().equals(selectedOption)){
                this.selectedOption = btn;
                btn.setSelected(true);
                optionListenerAction();
            }else btn.setSelected(false);

        }
    }
    public void setSelectedOption(int selectedOption) {
        for(int i = 0; i < getOptions().length; i++) {
            if(i == selectedOption) {
                this.selectedOption = getOptions()[i];
                getOptions()[i].setSelected(true);
                optionListenerAction();
            }else getOptions()[i].setSelected(false);
        }
    }
}
