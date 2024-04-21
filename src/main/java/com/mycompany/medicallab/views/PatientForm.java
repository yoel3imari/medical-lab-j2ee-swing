/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.medicallab.views;

import com.mycompany.medicallab.dao.PatientDao;
import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.models.Patient.Gender;
import java.util.Date;

/**
 *
 * @author yusef
 */
public class PatientForm extends javax.swing.JFrame {

    /**
     * Creates new form PatientForm
     */
    public PatientForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFName = new javax.swing.JTextField();
        textLName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        textCin = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textPhone = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnAddPatient = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("First Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Last Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        textFName.setColumns(1);
        textFName.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textFName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        textFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFNameActionPerformed(evt);
            }
        });
        getContentPane().add(textFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 175, 40));

        textLName.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textLName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        textLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLNameActionPerformed(evt);
            }
        });
        getContentPane().add(textLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 175, 40));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel11.setText("Gender");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel15.setText("Birth Date");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jComboBox1.setToolTipText("Gender");
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 175, 40));

        jDateChooser1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 175, 40));

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel12.setText("Identifier (CIN)");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        textCin.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textCin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        textCin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCinActionPerformed(evt);
            }
        });
        getContentPane().add(textCin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 175, 40));

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel16.setText("Phone Number");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        textPhone.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        textPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPhoneActionPerformed(evt);
            }
        });
        getContentPane().add(textPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 175, 40));

        textEmail.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(161, 195, 152), 2, true));
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        getContentPane().add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 368, 55));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(161, 195, 152));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(254, 253, 237));

        jButton1.setBackground(new java.awt.Color(250, 112, 112));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 253, 237));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAddPatient.setBackground(new java.awt.Color(161, 195, 152));
        btnAddPatient.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnAddPatient.setForeground(new java.awt.Color(254, 253, 237));
        btnAddPatient.setText("Add");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel13.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel13)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textLNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLNameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void textCinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCinActionPerformed

    private void textPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPhoneActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFNameActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        String fName = textFName.getText();
        String lName = textLName.getText();
        String gender = jComboBox1.getSelectedItem().toString();
        Date birthdate = jDateChooser1.getDate();
        String cin = textCin.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        Patient patient = new Patient();
        patient.setfName(fName);
        patient.setlName(lName);
        patient.setGender(Gender.valueOf(gender));
        patient.setBirthdate(birthdate);
        patient.setCin(cin);
        patient.setPhone(phone);
        patient.setEmail(email);
        
        PatientDao patientDao = new PatientDao();
        patientDao.savePatient(patient);
    }//GEN-LAST:event_btnAddPatientActionPerformed

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
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textCin;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFName;
    private javax.swing.JTextField textLName;
    private javax.swing.JTextField textPhone;
    // End of variables declaration//GEN-END:variables
}
