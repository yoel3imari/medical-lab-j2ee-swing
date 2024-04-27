/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.medicallab.views.tabs;

import com.mycompany.medicallab.dao.PatientDao;
import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.NotificationUtil;
import com.mycompany.medicallab.views.forms.PatientForm;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author yusef
 */
public class Patients extends javax.swing.JPanel {

    /**
     * Creates new form Patients
     */
    public Patients() {
        initComponents();
        populateTableModel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        btnUpdatePatient = new javax.swing.JButton();
        btnAddPatient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(254, 253, 237));
        setMaximumSize(new java.awt.Dimension(1080, 610));
        setMinimumSize(new java.awt.Dimension(1080, 610));
        setPreferredSize(new java.awt.Dimension(1080, 610));

        mainAppointements.setBackground(new java.awt.Color(254, 253, 237));
        mainAppointements.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainAppointements.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainAppointements.setMaximumSize(new java.awt.Dimension(900, 32767));
        mainAppointements.setMinimumSize(new java.awt.Dimension(900, 100));
        mainAppointements.setPreferredSize(new java.awt.Dimension(900, 638));

        jTextArea1.setColumns(18);
        jTextArea1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setToolTipText("");
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jButton1.setEnabled(false);

        btnDeletePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatientActionPerformed(evt);
            }
        });

        btnUpdatePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        btnUpdatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePatientActionPerformed(evt);
            }
        });

        btnAddPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        btnAddPatient.setToolTipText("");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        jTable1.setModel(jTable1.getModel());
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout mainAppointementsLayout = new javax.swing.GroupLayout(mainAppointements);
        mainAppointements.setLayout(mainAppointementsLayout);
        mainAppointementsLayout.setHorizontalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainAppointementsLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainAppointementsLayout.setVerticalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainAppointements, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAppointements, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        PatientForm patientForm = new PatientForm(this, "add");
        patientForm.setVisible(true);
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void btnUpdatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePatientActionPerformed
        // Get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Extract patient details from the selected row
            int id = (int) jTable1.getValueAt(selectedRowIndex, 0);
            String firstName = (String) jTable1.getValueAt(selectedRowIndex, 1);
            String lastName = (String) jTable1.getValueAt(selectedRowIndex, 2);
            String cin = (String) jTable1.getValueAt(selectedRowIndex, 3);
            String email = (String) jTable1.getValueAt(selectedRowIndex, 4);
            String phone = (String) jTable1.getValueAt(selectedRowIndex, 5);
            String gender = (String) jTable1.getValueAt(selectedRowIndex, 6);
            //Patient.Gender gender = (Patient.Gender) jTable1.getValueAt(selectedRowIndex, 6); // Retrieve gender as enum
            // Convert gender enum to string
            //String genderString = gender.toString();        

            Date birthDate = (Date) jTable1.getValueAt(selectedRowIndex, 7);

            // Print values for debugging
            System.out.println("id : " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("CIN: " + cin);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Gender: " + gender);

            // Open the PatientForm with the selected patient's details pre-filled
            PatientForm patientForm = new PatientForm(this, "update", id, firstName, lastName, cin, email, phone, gender, birthDate);
            patientForm.setVisible(true);

        } else {
            // Inform the user to select a row before modifying
            JOptionPane.showMessageDialog(null, "Please select a patient to modify.");
        }

    }//GEN-LAST:event_btnUpdatePatientActionPerformed

    private void btnDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatientActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) { // Ensure a row is selected

            int patientID = (int) jTable1.getValueAt(selectedRowIndex, 0);

            PatientDao PatientDao = new PatientDao();
            Patient patient = PatientDao.getPatientById(patientID);

            if (patient != null) {
                // Delete the patient record from the database
                boolean deletionSuccessful = PatientDao.deletePatient(patient);
                //PatientDao.deletePatient(patient);

                if (deletionSuccessful) {
                    // Remove the selected row from the table model
                    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    tableModel.removeRow(selectedRowIndex);
                    //JOptionPane.showMessageDialog(null, "Patient is deleted.");
                    NotificationUtil notification = new NotificationUtil("Patient is deleted.");
                    notification.show();
                } else {
                    // Handle deletion failure (display error message, etc.)
                    JOptionPane.showMessageDialog(null, "Failed to delete patient.");
                }
            } else {
                // Handle the case when no patient is found with the given CIN
                JOptionPane.showMessageDialog(null, "No patient found with the given CIN.");
            }
        } else {
            // Inform the user to select a row before deleting
            JOptionPane.showMessageDialog(null, "Please select a patient to delete.");
        }
    }//GEN-LAST:event_btnDeletePatientActionPerformed

    //search bar with no button 
    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        String search = jTextArea1.getText().toLowerCase();
        TableRowSorter tr = new TableRowSorter(tableModel);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextArea1KeyReleased

    public void populateTableModel() {
        
        //getAllPatients()
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        // Get column names
        String[] columnNames = {"Id", "Firstname", "Lastname", "CIN", "Email", "Phone", "Gender", "Birth Day"};
        // Update with actual column names
        tableModel.setColumnIdentifiers(columnNames);

        PatientDao patientDAO = new PatientDao();
        List<Patient> patients = patientDAO.getAllPatients();
        
        if( patients == null ) {
            return;
        }

        // Populate data rows
        for (Patient patient : patients) {
            Object[] row = new Object[]{
                patient.getId(),
                patient.getfName(),
                patient.getlName(),
                patient.getCin(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getGender(),
                patient.getBirthdate()};
            tableModel.addRow(row);
        }

        // Notify JTable to refresh its view
        tableModel.fireTableDataChanged(); // or fireTableStructureChanged() if the structure of the table has changed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Patients Management");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new Patients());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnUpdatePatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainAppointements;
    // End of variables declaration//GEN-END:variables
}
