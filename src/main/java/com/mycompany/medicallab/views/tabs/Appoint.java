/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.medicallab.views.tabs;

import com.mycompany.medicallab.calendar.CalendarEvent;
import com.mycompany.medicallab.calendar.WeekCalendar;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author yusef
 */
public class Appoint extends javax.swing.JPanel {

    /**
     * Creates new form Patients
     */
    public Appoint() {
        initComponents();
        createCalendar();
    }

    private void createCalendar() {
        // define events[]
        ArrayList<CalendarEvent> events = new ArrayList<>();
        // init WeekCalendar(events)
        WeekCalendar cal = new WeekCalendar(events);
        events.add(new CalendarEvent(LocalDate.of(2024, 04, 23), LocalTime.of(14, 0), LocalTime.of(14, 20), "Test 11/11 14:00-14:20"));
        events.add(new CalendarEvent(LocalDate.of(2024, 04, 27), LocalTime.of(9, 0), LocalTime.of(9, 20), "Test 14/11 9:00-9:20"));
        events.add(new CalendarEvent(LocalDate.of(2024, 04, 25), LocalTime.of(12, 0), LocalTime.of(13, 20), "Test 15/11 12:00-13:20"));
        // define buttons
        
        mainAppointements.add(cal, BorderLayout.CENTER);
        cal.setSize(1000, 900);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainAppointements = new javax.swing.JPanel();

        setBackground(new java.awt.Color(254, 253, 237));
        setMaximumSize(new java.awt.Dimension(1080, 610));
        setMinimumSize(new java.awt.Dimension(1080, 610));
        setPreferredSize(new java.awt.Dimension(1080, 610));

        mainAppointements.setBackground(new java.awt.Color(254, 253, 237));
        mainAppointements.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainAppointements.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainAppointements.setMaximumSize(new java.awt.Dimension(900, 600));
        mainAppointements.setMinimumSize(new java.awt.Dimension(900, 600));
        mainAppointements.setPreferredSize(new java.awt.Dimension(900, 600));
        mainAppointements.setLayout(new javax.swing.BoxLayout(mainAppointements, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainAppointements, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainAppointements, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainAppointements;
    // End of variables declaration//GEN-END:variables
}
