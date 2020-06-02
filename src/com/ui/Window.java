package com.ui;

import javax.swing.*;
import java.awt.*;

import com.util.Callback;
import com.util.KeyListener;

import java.awt.event.*;

public class Window {
    public static Window instance = new Window();
    JFrame mainFrame;
    GameFrame gameFrame;

    private Window() {
        mainFrame = new JFrame("Let's Play Mario");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(800, 450);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        panel.add(createButton("Level 1", "map.txt"));
        panel.add(createButton("Level 2", "map.txt"));
        panel.add(createButton("Level 3", "map.txt"));
        mainFrame.add(panel);
    }

    private JButton createButton(String title, String mapName) {
        JButton button = new JButton(title);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                onButtonPressed(title, mapName);
            }
        });
        return button;
    }

    private void onButtonPressed(String buttonTitle, String mapName) {
        if (gameFrame != null)
            gameFrame.dispose();
        try {
            gameFrame = new GameFrame(mapName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        gameFrame.addKeyListener(new KeyListener(gameFrame, new Callback() {
            public void execute() {
                onEsc();
            }
        }));
        gameFrame.start();
        mainFrame.setVisible(false);
    }

    public void run() {
        mainFrame.setVisible(true);
    }

    public void onEsc() {
        gameFrame.setVisible(false);
        gameFrame.dispose();
        gameFrame = null;
        mainFrame.setVisible(true);
    }
}