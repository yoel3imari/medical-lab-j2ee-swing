/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.medicallab.views.forms;

import com.mycompany.medicallab.calendar.CalendarEvent;
import com.mycompany.medicallab.calendar.WeekCalendar;
import com.mycompany.medicallab.dao.AppointmentDao;
import com.mycompany.medicallab.dao.PatientDao;
import com.mycompany.medicallab.dao.TestDao;
import com.mycompany.medicallab.models.Appointment;
import com.mycompany.medicallab.utils.NavManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.mycompany.medicallab.models.Test;
import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.JavaUtil;
import com.mycompany.medicallab.utils.NotificationUtil;
import java.util.HashMap;

/**
 *
 * @author yusef
 */
public class AppointmentForm extends javax.swing.JFrame {

    /**
     * Creates new form AppointementForm
     */
    private PatientDao pdo = new PatientDao();
    private TestDao tdo = new TestDao();
    private AppointmentDao ado = new AppointmentDao();

    private WeekCalendar cal;

    private CalendarEvent aptEvt = null;
    private Appointment aptToUpdate = null;

    private String cin;
    private Test selectedTest;
    private LocalDate date;
    private LocalTime time;

    private List<Test> testList;
    //private HashMap<Integer, String> testIdLabel = new HashMap();
    DefaultComboBoxModel<Test> comboBoxModel = new DefaultComboBoxModel<>();

    public AppointmentForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public AppointmentForm(WeekCalendar cal, LocalDateTime datetime) {
        this();
        date = datetime.toLocalDate();
        time = datetime.toLocalTime();
        this.cal = cal;

        appointDate.setText("Date: " + date);
        appointTime.setText("Time: " + time);

        testList = tdo.getAllTests();
        if (!testList.isEmpty()) {
            comboBoxModel.addAll(testList);
        }
    }

    // for update
    public AppointmentForm(WeekCalendar cal, CalendarEvent aptEvt) {
        this();
        this.aptEvt = aptEvt;
        aptToUpdate = aptEvt.getApt();
        patientCin.setText(aptToUpdate.getPatient().getCin());

        date = aptToUpdate.getDay();
        time = aptToUpdate.getHour();
        appointDate.setText("Date: " + date);
        appointTime.setText("Time: " + time);

        this.cal = cal;

        testList = tdo.getAllTests();
        if (!testList.isEmpty()) {
            comboBoxModel.addAll(testList);
        }
        comboBoxModel.setSelectedItem(aptToUpdate.getTest());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patientCin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        appointDate = new javax.swing.JLabel();
        appointTime = new javax.swing.JLabel();
        selectTests = new javax.swing.JComboBox<Test>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 253, 237));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(161, 195, 152));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appointement");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Patient Identifier (CIN)");

        patientCin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Select Tests");

        jButton1.setBackground(new java.awt.Color(250, 112, 112));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 253, 237));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(161, 195, 152));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 253, 237));
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        appointDate.setText("Date: __/__/__");

        appointTime.setText("Time: __:__");

        selectTests.setModel(comboBoxModel);
        selectTests.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        selectTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(appointDate)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(appointTime)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(patientCin, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectTests, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointDate)
                    .addComponent(appointTime))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientCin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectTests, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (aptToUpdate != null) {
            int option = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this Appointment?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                ado.deleteAppoint(aptToUpdate);
                cal.removeEvent(aptEvt);
                new NotificationUtil("Appointent Canceled!").show();
            }
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new PatientForm(NavManager.getTab("patients"), "add");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTestsActionPerformed
        // TODO add your handling code here:
        selectedTest = (Test) selectTests.getSelectedItem();
        JavaUtil.DumpPeek(selectedTest);

    }//GEN-LAST:event_selectTestsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        // verify if fields are not empty
        // if not create a new one and store it
        // verify if user exists
        // get tests ids
        // store the appointement in the appointments table
        if (selectedTest == null || patientCin.getText().isEmpty()) {
            JavaUtil.fireError(new Exception("There are some missing fields"));
        }

        cin = patientCin.getText();

        Patient p = pdo.getPatientByCIN(cin);

        Appointment newApt = new Appointment();
        newApt.setDay(date);
        newApt.setHour(time);
        newApt.setPatient(p);
        newApt.setTest(selectedTest);
        newApt.setState("pending");

        if (ado.saveAppoint(newApt)) {
            NotificationUtil notification = new NotificationUtil("Appointment Saved!");
            notification.show();
            cal.addEvent(
                    new CalendarEvent(
                            newApt,
                            newApt.getDay(),
                            newApt.getHour(),
                            newApt.getHour().plusMinutes(JavaUtil.regulateDuration(newApt.getTest().getDuration())),
                            selectedTest.getLabel()
                    ));

            dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointDate;
    private javax.swing.JLabel appointTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField patientCin;
    private javax.swing.JComboBox<Test> selectTests;
    // End of variables declaration//GEN-END:variables

}
