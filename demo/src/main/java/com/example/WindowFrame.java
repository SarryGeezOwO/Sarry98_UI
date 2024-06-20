package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.example.components.ImageButton;

public class WindowFrame extends JFrame {

    public enum FrameState {
        CLOSED, HIDE
    }

    private ImageIcon closeIcon;
    private ImageIcon maximizedIcon;
    private ImageIcon minimizedIcon;
    private ImageIcon hideIcon;

    private FrameState state;
    private boolean isFullScreen = false;

    private Color backgroundCol = new Color(170, 170, 180);

    public static String frameName;
    public static Font defaultFont;
    public static Font textFont;
    public JPanel mainPanel;            // Add all components here


    private boolean resisable;
    int xMouse = 0;
    int yMouse = 0;

    public static ImageIcon scaledIcon(String path, Vector2 size) {
        ImageIcon icn = new ImageIcon(path);
        Image root = icn.getImage();
        Image newImage = root.getScaledInstance(size.x, size.y, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    private void initAssets() {
        AssetHandler handler = new AssetHandler();
        closeIcon = handler.resizeIcon("/images/close.png", new Vector2(10, 10));
        maximizedIcon = handler.resizeIcon("/images/maximized.png", new Vector2(10, 10));
        minimizedIcon = handler.resizeIcon("/images/minimized.png", new Vector2(10, 10));
        hideIcon = handler.resizeIcon("/images/hide.png", new Vector2(10, 10));
        defaultFont = handler.loadFont("/fonts/Modeseven.ttf");
        textFont = handler.loadFont("/fonts/Windows Regular.ttf");
    }   

    public WindowFrame(String title, String displayTitle, Vector2 size, FrameState state, boolean resizable) {
        this.resisable = resizable;
        this.state = state;
        frameName = title;
        initAssets();
        initFrame(displayTitle, size);
        setTitle(title);
    }

    public WindowFrame(String title, Vector2 size, FrameState state, boolean resizable) {
        this.state = state;
        this.resisable = resizable;
        frameName = title;
        initAssets();
        initFrame(title, size);
        setTitle(title);
    }

    public WindowFrame(String title, Vector2 size) {
        frameName = title;
        this.state = FrameState.CLOSED;
        this.resisable = true;
        initAssets();
        initFrame(title, size);
        setTitle(title);
    }

    private void initFrame(String title, Vector2 size) {
        setSize(size.x, size.y + 25);   // +25 for titlebar
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BorderLayout());
        borderPanel.setOpaque(false);

        Color highlight = Color.LIGHT_GRAY;
        Color accentlight = Color.WHITE;
        Color accentShadow = Color.DARK_GRAY;
        Color shadow = Color.BLACK;
        borderPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED, highlight, shadow),
            BorderFactory.createBevelBorder(BevelBorder.RAISED, accentlight, accentShadow)
        ));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(backgroundCol);

        borderPanel.add(mainPanel, BorderLayout.CENTER);
        borderPanel.add(createTitlebar(title, size), BorderLayout.NORTH);
        add(borderPanel, BorderLayout.CENTER);
    }

    public JPanel createTitlebar(String title, Vector2 size) {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth(), h = getHeight();
                Color color1 = new Color(0, 0, 150);
                Color color2 = new Color(40, 80, 255);
                GradientPaint gp = new GradientPaint(w/4, 0, color1, w, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };

        p.setPreferredSize(new Dimension(1, 30));
        p.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 3));

        JLabel titleLabel = new JLabel(title, JLabel.LEFT);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(defaultFont.deriveFont(Font.PLAIN, 16f));
        titleLabel.setPreferredSize(new Dimension((resisable) ? (getWidth()-100) : (getWidth()-75), 25));

        ImageButton close = new ImageButton(closeIcon);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(state.equals(FrameState.CLOSED)) System.exit(0);
                else dispose();
            }
        });
        ImageButton minMax = new ImageButton(maximizedIcon);
        minMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFullScreen = !isFullScreen;
                setExtendedState((isFullScreen) ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);
                minMax.setIcon((isFullScreen) ? minimizedIcon : maximizedIcon);
            }
        });
        ImageButton hide = new ImageButton(hideIcon);
        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });

        p.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                super.mouseDragged(e);
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();

                if((x - xMouse > 0) || (y - yMouse > 0)) {
                    if(isFullScreen) {
                        setExtendedState(JFrame.NORMAL);
                        isFullScreen = false;
                        minMax.setIcon(maximizedIcon);
                    }
                    setLocation(
                        ((x - xMouse > 0) ? x - xMouse : 0), 
                        ((y - yMouse > 0) ? y - yMouse : 0)
                    ); 
                }
            }
        });
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        ComponentResizer resizer = new ComponentResizer();
        if(resisable) {
            resizer.registerComponent(this);
            resizer.setSnapSize(new Dimension(10, 10));
            resizer.setMinimumSize(new Dimension(size.x, size.y));
        }

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                p.removeAll();
                revalidate();

                if(isFullScreen) {
                    resizer.setDragInsets(new Insets(0, 0, 0, 0));
                }else {
                    resizer.setDragInsets(new Insets(5, 5, 5, 5));
                }

                titleLabel.setPreferredSize(new Dimension((resisable) ? (getWidth()-100) : (getWidth()-75), 25));
                p.add(titleLabel);
                p.add(hide);
                if(resisable) {
                    p.add(minMax);
                }
                p.add(close);
                revalidate();
                repaint();
            }
        });

        p.add(titleLabel);
        p.add(hide);
        if(resisable) {
            p.add(minMax);
        }
        p.add(close);
        return p;
    }

}
