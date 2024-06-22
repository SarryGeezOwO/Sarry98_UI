package com.Sarry_98.components;

import com.Sarry_98.OldScrollbarUI;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane {

    public enum ScrollType {
        VERTICAL, HORIZONTAL, BOTH, AUTO
    }

    public ScrollPanel(Component component, ScrollType type) {
        super(component);
        getVerticalScrollBar().setUI(new OldScrollbarUI());
        getHorizontalScrollBar().setUI(new OldScrollbarUI());
        if(type == ScrollType.VERTICAL) {
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        }
        else if (type == ScrollType.HORIZONTAL) {
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
        else if (type == ScrollType.BOTH) {
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
        else if (type == ScrollType.AUTO) {
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }

        verticalScrollBar.setUnitIncrement(20); // Increase vertical scroll speed
        horizontalScrollBar.setUnitIncrement(20); // Increase horizontal scroll speed
    }

}
