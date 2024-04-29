/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.medicallab.views.tabs;

import com.mycompany.medicallab.calendar.CalendarEvent;
import com.mycompany.medicallab.calendar.WeekCalendar;
import com.mycompany.medicallab.dao.AppointmentDao;
import com.mycompany.medicallab.models.Appointment;
import com.mycompany.medicallab.utils.JavaUtil;
import com.mycompany.medicallab.utils.NotificationUtil;
import com.mycompany.medicallab.views.forms.AppointmentForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yusef
 */
public class Appoint extends javax.swing.JPanel {

    AppointmentDao ado = new AppointmentDao();
    WeekCalendar cal;
    ArrayList<CalendarEvent> events = new ArrayList<>();
    List<Appointment> weekApt;

    /**
     * Creates new form Patients
     */
    public Appoint() {
        initComponents();
        
        mainAppointements.setLayout(new BoxLayout(mainAppointements, BoxLayout.Y_AXIS));
        mainAppointements.setSize(1080, 610);
        mainAppointements.add(Box.createVerticalGlue());
        
        weekApt = new ArrayList<>();
        createCalendar();

    }

    private void createCalendar() {

        cal = new WeekCalendar(events);
        cal.setSize(1000, 900);
        
        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());
        JButton nextWeekBtn = new JButton(">");
        nextWeekBtn.addActionListener(e -> cal.nextWeek());
        JButton nextMonthBtn = new JButton(">>");
        nextMonthBtn.addActionListener(e -> cal.nextMonth());
        
        JPanel weekControls = new JPanel();
        weekControls.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        weekControls.setMinimumSize(new Dimension(Integer.MAX_VALUE, 50));
        weekControls.add(goToTodayBtn);
        weekControls.add(nextWeekBtn);
        weekControls.add(nextMonthBtn);
        
        cal.addCalendarEmptyClickListener(e -> {
            LocalDateTime ldt = JavaUtil.regulateDateTime(e.getDateTime());
            if (ldt.isAfter(LocalDateTime.now())) {
                new AppointmentForm(cal, ldt);
            } else {
                new NotificationUtil("Selected Box Expired").show();
            }
        });
        cal.addCalendarEventClickListener(e -> {
            // get appoint
            new AppointmentForm(cal, e.getCalendarEvent());
        });
        weekApt = ado.getAppointBetween(LocalDate.now(), JavaUtil.getNextSaturday(LocalDate.now()));
        displayEvents();
        
        mainAppointements.add(weekControls);
        mainAppointements.add(cal, BorderLayout.CENTER);
    }

    private void displayEvents() {
        weekApt.forEach(evt -> {
            cal.addEvent(new CalendarEvent(
                    evt,
                    evt.getDay(),
                    evt.getHour(),
                    evt.getHour().plusMinutes(evt.getTest().getDuration()),
                    evt.getTest().getLabel()
            ));
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainAppointements = new javax.swing.JPanel();

        setBackground(new java.awt.Color(254, 253, 237));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        setMaximumSize(new java.awt.Dimension(1080, 610));
        setMinimumSize(new java.awt.Dimension(1080, 610));
        setPreferredSize(new java.awt.Dimension(1080, 610));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1040, 600));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1040, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1040, 600));

        mainAppointements.setBackground(new java.awt.Color(254, 253, 237));
        mainAppointements.setMaximumSize(new java.awt.Dimension(1080, 610));
        mainAppointements.setMinimumSize(new java.awt.Dimension(1080, 610));
        mainAppointements.setPreferredSize(new java.awt.Dimension(1080, 610));

        javax.swing.GroupLayout mainAppointementsLayout = new javax.swing.GroupLayout(mainAppointements);
        mainAppointements.setLayout(mainAppointementsLayout);
        mainAppointementsLayout.setHorizontalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        mainAppointementsLayout.setVerticalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainAppointements);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainAppointements;
    // End of variables declaration//GEN-END:variables
}
