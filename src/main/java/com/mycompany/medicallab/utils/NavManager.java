/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.utils;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author yusef
 */
public class NavManager {
    
    private Map<String, Component> tabs = new HashMap<>();
    private Map<String, Component> navItems = new HashMap();
    
    private String current = null;
    
    private final Color hoverColor = new Color(153,255,204);
    private final Color hoverText = new Color(27,60,115);
    private final Color normalColor = new Color(204,255,204);
    private final Color normalText = new Color(0,0,0);
    
    public void addTab(String label, Component tab) { tabs.put(label, tab); }
    
    public void addNavItem(String label, Component tab) { navItems.put(label, tab); }
    
    public void setActive (String tab) {
        if(current == null) {
            current = tab;
        }
        // reset current tab to unvisible
        tabs.get(current).setVisible(false);
        
        // set current navItem background
        navItems.get(current).setBackground(normalColor);
        navItems.get(current).setForeground(normalText);
        // change next navItem background
        navItems.get(tab).setBackground(hoverColor);
        navItems.get(tab).setForeground(hoverText);
        
        // set next tab as visible
        tabs.get(tab).setVisible(true);
        
        current = tab;   
    }
    
    public Component getActive() {
        return tabs.get(current);
    }
}
