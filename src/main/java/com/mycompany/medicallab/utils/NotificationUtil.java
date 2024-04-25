/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.utils;

/**
 *
 * @author dev23
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class NotificationUtil {

    private static final int TOAST_WIDTH = 300;
    private static final int TOAST_HEIGHT = 80;
    private static final int TOAST_DURATION = 3000; // Duration in milliseconds
    private static final int FADE_OUT_DURATION = 500; // Fade out duration in milliseconds

    private String message;
    private int x;
    private int y;

    public NotificationUtil(String message, int x, int y) {
        this.message = message;
        this.x = x;
        this.y = y;
    }
    // new contrsuctor for new method of calling the notification 
    public NotificationUtil(String message) {
        this.message = message;
    }
    

    public void show() {
        JWindow window = new JWindow();
        window.setBackground(new Color(0, 0, 0, 0));
        window.setAlwaysOnTop(true); // Show toast above all other windows

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();

                // Draw background
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.WHITE, 0, height, Color.LIGHT_GRAY);
                g2d.setPaint(gradientPaint);
                g2d.fillRoundRect(0, 0, width, height, 20, 20);
                
                 // Draw shadow borders
                g2d.setColor(new Color(0, 0, 0, 50)); // Semi-transparent black color
                for (int i = 0; i < 3; i++) {
                    g2d.drawRoundRect(i, i, width - 2 * i - 1, height - 2 * i - 1, 20, 20);
                }
                // Draw inner border
                g2d.setColor(Color.GRAY);
                g2d.drawRoundRect(0, 0, width - 1, height - 1, 20, 20);
            
                // Draw border
                //g2d.setColor(Color.GRAY);
                //g2d.drawRoundRect(0, 0, width - 1, height - 1, 20, 20);

                // Draw message
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.PLAIN, 17)); 
                FontMetrics fm = g2d.getFontMetrics();
                int stringWidth = fm.stringWidth(message);
                int stringHeight = fm.getHeight();
                g2d.drawString(message, (width - stringWidth) / 2, (height - stringHeight) / 2 + fm.getAscent());

                g2d.dispose();
            }
        };
        panel.setPreferredSize(new Dimension(TOAST_WIDTH, TOAST_HEIGHT));
        window.add(panel);

        // Calculate toast position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowX = screenSize.width - TOAST_WIDTH - 20; // 20 pixels from right
        int windowY = screenSize.height - TOAST_HEIGHT - 40; // 40 pixels from bottom
        window.setLocation(windowX, windowY);

        window.pack();
        window.setVisible(true);

        // Close the toast after a certain duration
        new Thread(() -> {
            try {
                Thread.sleep(TOAST_DURATION);
                float opacity = 1.0f;
                long start = System.currentTimeMillis();
                while (opacity > 0.0f) {
                    long elapsedTime = System.currentTimeMillis() - start;
                    float fadeRatio = (float) elapsedTime / FADE_OUT_DURATION;
                    opacity = 1.0f - fadeRatio;
                    window.setOpacity(Math.max(0.0f, opacity));
                    Thread.sleep(20);
                }
                window.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Modern Toast Demo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//        frame.setLocationRelativeTo(null);

        //JButton button = new JButton("Show Toast");
       // button.addActionListener(e -> {
            NotificationUtil notification = new NotificationUtil("badr eddine");//, frame.getX(), frame.getY());
            notification.show();
        //});

//        frame.getContentPane().add(button, BorderLayout.CENTER);
//        frame.setVisible(true);
    }
}
