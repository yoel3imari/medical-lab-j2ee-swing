package com.mycompany.medicallab.testings;

import com.mycompany.medicallab.views.tabs.Appoint;
import java.awt.Dimension;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yusef
 */
public class AppointTests {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1080, 610);
        
        Appoint app = new Appoint();
        frame.getContentPane().add(app);
        frame.setVisible(true);
    }
}
