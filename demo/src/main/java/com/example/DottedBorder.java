package com.example;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DottedBorder {
        public static Border createDottedBorder(Color color) {
        float dash1[] = {2.0f};
        BasicStroke dashed = new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dash1, 0.0f);
        return BorderFactory.createStrokeBorder(dashed, color);
    }
}