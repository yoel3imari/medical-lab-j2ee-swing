/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.medicallab.views.tabs;

import com.mycompany.medicallab.dao.AppointmentDao;
import com.mycompany.medicallab.dao.DashboardDao;
import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import com.mycompany.medicallab.dao.TestDao;
import com.mycompany.medicallab.models.Appointment;
import com.mycompany.medicallab.utils.NavManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusef
 */
public class Dashboard extends javax.swing.JPanel {

    private Appoint aptPanel;

    List<Appointment> appointments = new ArrayList<>();
    Appointment currentApt = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    TestDao testDao = null;
    DashboardDao dashboardDao = null;
    AppointmentDao appointmentDao = null;

    DefaultTableModel appointmentTableModel;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {

        initComponents();

        testDao = new TestDao();
        dashboardDao = new DashboardDao();
        appointmentDao = new AppointmentDao();

        appointmentTableModel = (DefaultTableModel) appointmentTable.getModel(); // get the table model
        appointmentTableModel.setRowCount(0); // Clear existing rows
        // Get column names
        String[] columnNames = {"Full Name", "CIN", "From", "To"};
        // Update with actual column names
        appointmentTableModel.setColumnIdentifiers(columnNames);

        populateAppointmantTable();
        populateCurrentAppointment();
        displayTodaysTests();
        populateResultTable();
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
        jPanel15 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        currCIN = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        currTest = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        currFullName = new javax.swing.JLabel();
        currFrom = new javax.swing.JLabel();
        currTo = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnNextAppointment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 253, 237));
        setMaximumSize(new java.awt.Dimension(1080, 610));
        setMinimumSize(new java.awt.Dimension(1080, 610));
        setPreferredSize(new java.awt.Dimension(1080, 610));

        mainAppointements.setBackground(new java.awt.Color(254, 253, 237));
        mainAppointements.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainAppointements.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainAppointements.setMaximumSize(new java.awt.Dimension(1080, 610));
        mainAppointements.setMinimumSize(new java.awt.Dimension(1080, 610));
        mainAppointements.setPreferredSize(new java.awt.Dimension(1080, 610));

        jPanel15.setBackground(new java.awt.Color(254, 253, 237));
        jPanel15.setMaximumSize(new java.awt.Dimension(860, 10));
        jPanel15.setMinimumSize(new java.awt.Dimension(860, 120));
        jPanel15.setPreferredSize(new java.awt.Dimension(860, 120));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBackground(new java.awt.Color(254, 253, 237));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel12.setBackground(new java.awt.Color(254, 253, 237));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 5, 5));

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 153));
        jLabel31.setText("Next Appointment");

        jLabel32.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel32.setText("Fullname:");

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel33.setText("CIN: ");

        currCIN.setText("_______");

        jLabel35.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel35.setText("Test:");

        currTest.setText("_______");

        jLabel37.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel37.setText("From: ");

        jLabel38.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel38.setText("To: ");

        currFullName.setText("___________");

        currFrom.setText("__:__");

        currTo.setText("__:__");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currFrom))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currFullName)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currCIN))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currTo))))
                    .addComponent(jLabel31)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currTest)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(currCIN)
                    .addComponent(currFullName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(currTest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(currFrom)
                    .addComponent(jLabel38)
                    .addComponent(currTo))
                .addContainerGap())
        );

        jPanel5.add(jPanel12, new java.awt.GridBagConstraints());

        jPanel10.setBackground(new java.awt.Color(254, 253, 237));
        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        btnNextAppointment.setBackground(new java.awt.Color(153, 255, 153));
        btnNextAppointment.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        btnNextAppointment.setForeground(new java.awt.Color(27, 60, 115));
        btnNextAppointment.setText("Next");
        btnNextAppointment.setPreferredSize(new java.awt.Dimension(300, 75));
        btnNextAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextAppointmentActionPerformed(evt);
            }
        });
        jPanel10.add(btnNextAppointment, new java.awt.GridBagConstraints());

        jPanel5.add(jPanel10, new java.awt.GridBagConstraints());

        jPanel15.add(jPanel5);

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Full Name", "CIN", "From", "To"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(appointmentTable);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Test", "Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setText("Today's Appointment");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Today's Tests");

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Full Name", "CIN", "Test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(resultTable);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText("Today's Results");

        javax.swing.GroupLayout mainAppointementsLayout = new javax.swing.GroupLayout(mainAppointements);
        mainAppointements.setLayout(mainAppointementsLayout);
        mainAppointementsLayout.setHorizontalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainAppointementsLayout.createSequentialGroup()
                        .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainAppointementsLayout.setVerticalGroup(
            mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainAppointementsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainAppointementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainAppointementsLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainAppointements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainAppointements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextAppointmentActionPerformed
        // TODO add your handling code here:

        currFullName.setText("___________");
        currCIN.setText("___________");
        currTest.setText("______________________");
        currFrom.setText("__:__");
        currTo.setText("__:__");

        dashboardDao.endAppointmentById(currentApt.getId());
        currentApt = null;
        // you can populateAppointmant Table  only if appointments list is not empty 
        populateAppointmantTable();
        displayTodaysTests();

        aptPanel.populateWeekCalendar();
    }//GEN-LAST:event_btnNextAppointmentActionPerformed

    public void populateAppointmantTable() {

        // to get results from data base and store in them a list named appointments  
        appointments = appointmentDao.getTodaysAppointments();

        if (!appointments.isEmpty()) {
            currentApt = appointments.get(0);
            populateCurrentAppointment();
            appointments.remove(0);

            for (int i = appointmentTableModel.getRowCount() - 1; i >= 0; i--) {
                appointmentTableModel.removeRow(i);
            }

            // Populate data rows but excluding first appoitment so it can show in current appointment jPanel
            for (Appointment apt : appointments) {
                String fullname = apt.getPatient().getfName() + apt.getPatient().getlName();
                String cin = apt.getPatient().getCin();
                String from_hour = apt.getHour().format(formatter);
                String to_hour = apt.getHour().plusMinutes(JavaUtil.regulateDuration(apt.getTest().getDuration())).format(formatter);
                Object[] row = new Object[]{fullname, cin, from_hour, to_hour};
                appointmentTableModel.addRow(row);
            }
            // Notify JTable to refresh its view
            appointmentTableModel.fireTableDataChanged(); // or fireTableStructureChanged() if the structure of the table has changed
        } else {
            currFullName.setText("___________");
            currCIN.setText("___________");
            currTest.setText("______________________");
            currFrom.setText("__:__");
            currTo.setText("__:__");
        }
    }

    public void populateCurrentAppointment() {

        if (currentApt == null) {
            currFullName.setText("___________");
            currCIN.setText("___________");
            currTest.setText("______________________");
            currFrom.setText("__:__");
            currTo.setText("__:__");

            return;
        }

        String fullName = currentApt.getPatient().getfName() + currentApt.getPatient().getlName();
        String cin = currentApt.getPatient().getCin();
        String from = currentApt.getHour().format(formatter);
        String to = currentApt.getHour().plusMinutes(JavaUtil.regulateDuration(currentApt.getTest().getDuration())).format(formatter);
        String test = currentApt.getTest().getLabel();

        currFullName.setText(fullName);
        currCIN.setText(cin);
        currTest.setText(test);
        currFrom.setText(from);
        currTo.setText(to);
    }

    private void populateResultTable() {
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel(); // get the table model
        resultTableModel.setRowCount(0); // Clear existing rows
        // Get column names
        String[] columnNames = {"Full Name", "CIN", "Test"};
        // Update with actual column names
        resultTableModel.setColumnIdentifiers(columnNames);

        // to get results from data base and store in them a list named results 
        List<Object[]> results = new ArrayList<>();
        results = dashboardDao.getTodaysResults();

        // printing to debug 
        System.out.println("results :\n" + results);
        for (Object[] itemArray : results) {
            for (Object item : itemArray) {
                System.out.print(item + " ");
            }
            System.out.println(); // Add a new line after each array
        }
        // Populate data rows
        for (Object[] resultArray : results) {
            String fullname = resultArray[0].toString() + " " + resultArray[1].toString();
            String cin = resultArray[2].toString();
            String test = resultArray[3].toString();
            Object[] row = new Object[]{fullname, cin, test};
            resultTableModel.addRow(row);
        }

        // Notify JTable to refresh its view
        resultTableModel.fireTableDataChanged(); // or fireTableStructureChanged() if the structure of the table has changed
    }

    public void displayTodaysTests() {
        // Fetch today's tests and counts from the database
        List<Object[]> data = testDao.getTodaysTestsAndCounts();

        // Populate the table with fetched data
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    public Appoint getAptPanel() {
        return aptPanel;
    }

    public void setAptPanel(Appoint aptPanel) {
        this.aptPanel = aptPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointmentTable;
    private javax.swing.JButton btnNextAppointment;
    private javax.swing.JLabel currCIN;
    private javax.swing.JLabel currFrom;
    private javax.swing.JLabel currFullName;
    private javax.swing.JLabel currTest;
    private javax.swing.JLabel currTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel mainAppointements;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
}
