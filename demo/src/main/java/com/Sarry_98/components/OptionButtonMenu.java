package com.Sarry_98.components;

import com.Sarry_98.CheckboxListener;

import javax.swing.*;
import java.awt.*;

public class OptionButtonMenu extends JPanel {

    private OptionButton[] options;
    private OptionButton selectedOption;

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
                btn.setSelected(true);
                this.selectedOption = btn;
            }else btn.setSelected(false);

        }
    }
    public void setSelectedOption(int selectedOption) {
        for(int i = 0; i < getOptions().length; i++) {
            if(i == selectedOption) {
                this.selectedOption = getOptions()[i];
                getOptions()[i].setSelected(true);
            }else getOptions()[i].setSelected(false);
        }
    }
}
