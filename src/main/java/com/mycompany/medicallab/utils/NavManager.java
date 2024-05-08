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
    
    /**
     * key values of tabs and their JPanels
     */
    private static Map<String, JPanel> tabs = new HashMap<>();
    
    /**
     * key values of navItems and their JPanel
     */
    private static Map<String, JPanel> navItems = new HashMap();
    
    /**
     * current tab
     */
    private static String current = null;
    
    private static final Color hoverColor = new Color(153,255,204);
    private static final Color hoverText = new Color(27,60,115);
    private static final Color normalColor = new Color(204,255,204);
    private static final Color normalText = new Color(0,0,0);
    
    /**
     * 
     * @param label the tab title
     * @param tab the tab 
     */
    public static void addTab(String label, JPanel tab) { tabs.put(label, tab); }
    
    /**
     * 
     * @param label navigation label..to change it's background when the tab is active
     * @param tab the tab nav item
     */
    public static void addNavItem(String label, JPanel tab) { navItems.put(label, tab); }
    
    /**
     * activate a certain tab using it's key
     * @param tab 
     */
    public static void setActive (String tab) {
        // when app opens for the first time current is null
        if(current == null) {
            current = tab;
        }
        
        // disable the current tab
        tabs.get(current).setVisible(false);
        // set current navItem background as normal
        navItems.get(current).setBackground(normalColor);
        navItems.get(current).setForeground(normalText);
        
        // change next navItem background
        navItems.get(tab).setBackground(hoverColor);
        navItems.get(tab).setForeground(hoverText);
        // set next tab as visible
        tabs.get(tab).setVisible(true);
        
        // switch current tab
        current = tab;
    }
    
    /**
     * 
     * @return active or current JPanel
     */
    public static JPanel getActive() {
        return tabs.get(current);
    }
    
    /**
     * useful for interaction between tabs like dashboard and appointments
     * @param label the key of the tab
     * @return the tab
     */
    public static JPanel getTab(String label) {
        if( tabs.containsKey(label) ) {
            return tabs.get(label);
        } else {
            JavaUtil.fireError(new Exception("Tab does not exists"));
            return null;
        }
    }
}
