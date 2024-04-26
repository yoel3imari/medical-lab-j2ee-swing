/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.medicallab.views.tabs;

import com.mycompany.medicallab.dao.TestDao;
import com.mycompany.medicallab.models.Test;
import com.mycompany.medicallab.views.forms.TestForm;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusef
 */
public class Tests extends javax.swing.JPanel {

    private final TestDao testDao;
    private final DefaultTableModel tableModel;

    /**
     * Creates new form Tests
     *
     */
    public Tests() {
        initComponents();
        testDao = new TestDao();
        tableModel = (DefaultTableModel) jTable1.getModel();
        displayTestData();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnChearch_Test = new javax.swing.JButton();
        btnDelete_Test = new javax.swing.JButton();
        btnUpdate_Test = new javax.swing.JButton();
        btnAdd_Test = new javax.swing.JButton();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "Phone", "CIN", "Birth Day", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(1);
        jScrollPane2.setViewportView(jTextArea1);

        btnChearch_Test.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnChearch_Test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N

        btnDelete_Test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N

        btnAdd_Test.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        btnAdd_Test.setToolTipText("");
        btnAdd_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_TestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainAppointementsLayout = new javax.swing.GroupLayout(mainAppointements);
        mainAppointements.setLayout(mainAppointementsLayout);
        mainAppointementsLayout.setHorizontalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnChearch_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
                .addComponent(btnDelete_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnUpdate_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnAdd_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        mainAppointementsLayout.setVerticalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChearch_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

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

    private void btnAdd_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_TestActionPerformed
        // Create a new instance of the test form/dialog
        TestForm testForm = new TestForm();

        // Make the form/dialog visible
        testForm.setVisible(true);

    }//GEN-LAST:event_btnAdd_TestActionPerformed
    public void displayTestData() {
        // Clear existing data from the table
        tableModel.setRowCount(0);

        // Retrieve test data from the database
        List<Test> tests = testDao.getAllTests();

        String[] columnNames = {"Id", "lable", "price", "days_to_get_result", "type", "description"}; // Update with actual column names
        tableModel.setColumnIdentifiers(columnNames);

        // Populate the table with test data
        for (Test test : tests) {
            Object[] rowData = {
                test.getId(),
                test.getLabel(),
                test.getPrice(),
                test.getDaysToGetResult(),
                test.getDescription(),
                test.getofType()
            // Add more columns as needed
            };
            tableModel.addRow(rowData);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd_Test;
    private javax.swing.JButton btnChearch_Test;
    private javax.swing.JButton btnDelete_Test;
    private javax.swing.JButton btnUpdate_Test;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainAppointements;
    // End of variables declaration//GEN-END:variables
}
