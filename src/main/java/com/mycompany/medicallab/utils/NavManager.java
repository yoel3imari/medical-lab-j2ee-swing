/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author yusef
 */
public class NavManager {
    
    private Map<String, JPanel> tabs = new HashMap<>();
    private JPanel current;
    private final Color hoverColor = new Color(153,255,204);
    private final Color normalColor = new Color(204,255,204);
    
    public void addTab(String label, JPanel tab) { tabs.put(label, tab); }
    
    public void setActive (String tab) {
        
        current.setVisible(false);
        current.setBackground(normalColor);
        
        for(Map.Entry<String, JPanel> elm : tabs.entrySet()) {
            if( elm.getKey().equals(tab) ) {
                elm.getValue().setVisible(true);
                elm.getValue().setBackground(hoverColor);
                current = elm.getValue();
                break;
            }
        }
    }
}
