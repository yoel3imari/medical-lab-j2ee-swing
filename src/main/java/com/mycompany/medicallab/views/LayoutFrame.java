/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.medicallab.views;

import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.NavManager;
import com.mycompany.medicallab.views.tabs.*;
import java.awt.BorderLayout;
import java.awt.Component;

/**
 *
 * @author yusef
 */
public class LayoutFrame extends javax.swing.JFrame {

    NavManager nav = null;

    /**
     * Creates new form LayoutFrame
     */
    public LayoutFrame() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        //Component appointements = new Appoint();
        //Component patients = new Patients();
        //Component tests = new Tests();

        // init navigation
        String[] tabs = {"dashboard", "appointements", "patients", "tests"};
        Class[] cmp = {Dashboard.class, Appoint.class, Patients.class, Tests.class};
        Component[] navCmp = {dashboardNavItem, appointementsNavItem, patientsNavItem, testsNavItem};

        for (int i = 0; i < tabs.length; i++) {
            //cmp[i].setVisible(false);
            NavManager.addTab(tabs[i], cmp[i]);
            NavManager.addNavItem(tabs[i], navCmp[i]);
        }

        nav.setActive("dashboard");
        tabContainer.add(Dashboard.getInstance(), BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sidebarMenu = new javax.swing.JPanel();
        dashboardNavItem = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        appointementsNavItem = new javax.swing.JPanel();
        appointementsLabel = new javax.swing.JLabel();
        patientsNavItem = new javax.swing.JPanel();
        patientsLabel = new javax.swing.JLabel();
        testsNavItem = new javax.swing.JPanel();
        testsLabel = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        tabTitle = new javax.swing.JLabel();
        tabContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 253, 237));
        setMinimumSize(new java.awt.Dimension(1300, 700));

        sidebar.setBackground(new java.awt.Color(254, 253, 237));
        sidebar.setMaximumSize(new java.awt.Dimension(220, 32767));
        sidebar.setMinimumSize(new java.awt.Dimension(220, 700));
        sidebar.setPreferredSize(new java.awt.Dimension(220, 700));

        logo.setBackground(new java.awt.Color(204, 255, 204));
        logo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logo.setMaximumSize(new java.awt.Dimension(220, 90));
        logo.setMinimumSize(new java.awt.Dimension(220, 90));
        logo.setPreferredSize(new java.awt.Dimension(220, 90));
        logo.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setAlignmentX(20.0F);
        logo.add(jLabel6, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 60, 115));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel3.setText("SwingLab");
        jLabel3.setAlignmentX(20.0F);
        jLabel3.setIconTextGap(10);
        logo.add(jLabel3, new java.awt.GridBagConstraints());

        sidebarMenu.setBackground(new java.awt.Color(204, 255, 204));
        sidebarMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 10, 10, 10));
        sidebarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sidebarMenu.setFocusCycleRoot(true);
        sidebarMenu.setLayout(new java.awt.GridLayout(5, 1, 10, 10));

        dashboardNavItem.setBackground(new java.awt.Color(153, 255, 204));
        dashboardNavItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        dashboardNavItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardNavItem.setMaximumSize(new java.awt.Dimension(129, 70));
        dashboardNavItem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                dashboardNavItemAncestorRemoved(evt);
            }
        });
        dashboardNavItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardNavItemMouseClicked(evt);
            }
        });
        dashboardNavItem.setLayout(new javax.swing.BoxLayout(dashboardNavItem, javax.swing.BoxLayout.LINE_AXIS));

        dashboardLabel.setBackground(new java.awt.Color(254, 253, 237));
        dashboardLabel.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        dashboardLabel.setForeground(new java.awt.Color(27, 60, 115));
        dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard.png"))); // NOI18N
        dashboardLabel.setText("Dashboad");
        dashboardLabel.setToolTipText("");
        dashboardLabel.setIconTextGap(10);
        dashboardLabel.setMaximumSize(new java.awt.Dimension(200, 70));
        dashboardLabel.setMinimumSize(new java.awt.Dimension(200, 70));
        dashboardLabel.setPreferredSize(new java.awt.Dimension(200, 70));
        dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardLabelMouseClicked(evt);
            }
        });
        dashboardNavItem.add(dashboardLabel);

        sidebarMenu.add(dashboardNavItem);

        appointementsNavItem.setBackground(new java.awt.Color(204, 255, 204));
        appointementsNavItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        appointementsNavItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appointementsNavItem.setMaximumSize(new java.awt.Dimension(129, 70));
        appointementsNavItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sidebarItemHover(evt);
            }
        });
        appointementsNavItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointementsNavItemMouseClicked(evt);
            }
        });
        appointementsNavItem.setLayout(new javax.swing.BoxLayout(appointementsNavItem, javax.swing.BoxLayout.LINE_AXIS));

        appointementsLabel.setBackground(new java.awt.Color(254, 253, 237));
        appointementsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        appointementsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appointement.png"))); // NOI18N
        appointementsLabel.setText("Appointments");
        appointementsLabel.setToolTipText("");
        appointementsLabel.setIconTextGap(10);
        appointementsLabel.setMaximumSize(new java.awt.Dimension(200, 70));
        appointementsLabel.setMinimumSize(new java.awt.Dimension(200, 70));
        appointementsLabel.setPreferredSize(new java.awt.Dimension(129, 70));
        appointementsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointementsLabelMouseClicked(evt);
            }
        });
        appointementsNavItem.add(appointementsLabel);

        sidebarMenu.add(appointementsNavItem);

        patientsNavItem.setBackground(new java.awt.Color(204, 255, 204));
        patientsNavItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        patientsNavItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientsNavItem.setMaximumSize(new java.awt.Dimension(129, 70));
        patientsNavItem.setPreferredSize(new java.awt.Dimension(129, 70));
        patientsNavItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsNavItemMouseClicked(evt);
            }
        });
        patientsNavItem.setLayout(new javax.swing.BoxLayout(patientsNavItem, javax.swing.BoxLayout.LINE_AXIS));

        patientsLabel.setBackground(new java.awt.Color(254, 253, 237));
        patientsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        patientsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient.png"))); // NOI18N
        patientsLabel.setText("Patients");
        patientsLabel.setToolTipText("");
        patientsLabel.setIconTextGap(10);
        patientsLabel.setMaximumSize(new java.awt.Dimension(200, 70));
        patientsLabel.setMinimumSize(new java.awt.Dimension(200, 70));
        patientsLabel.setPreferredSize(new java.awt.Dimension(129, 70));
        patientsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsLabelMouseClicked(evt);
            }
        });
        patientsNavItem.add(patientsLabel);

        sidebarMenu.add(patientsNavItem);

        testsNavItem.setBackground(new java.awt.Color(204, 255, 204));
        testsNavItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        testsNavItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        testsNavItem.setMaximumSize(new java.awt.Dimension(129, 70));
        testsNavItem.setPreferredSize(new java.awt.Dimension(129, 70));
        testsNavItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testsNavItemMouseClicked(evt);
            }
        });
        testsNavItem.setLayout(new javax.swing.BoxLayout(testsNavItem, javax.swing.BoxLayout.LINE_AXIS));

        testsLabel.setBackground(new java.awt.Color(254, 253, 237));
        testsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        testsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/test.png"))); // NOI18N
        testsLabel.setText("Tests");
        testsLabel.setToolTipText("");
        testsLabel.setIconTextGap(10);
        testsLabel.setMaximumSize(new java.awt.Dimension(200, 70));
        testsLabel.setMinimumSize(new java.awt.Dimension(200, 70));
        testsLabel.setPreferredSize(new java.awt.Dimension(200, 70));
        testsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testsLabelMouseClicked(evt);
            }
        });
        testsNavItem.add(testsLabel);

        sidebarMenu.add(testsNavItem);

        logout.setBackground(new java.awt.Color(0, 0, 102));
        logout.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setMaximumSize(new java.awt.Dimension(220, 90));
        logout.setMinimumSize(new java.awt.Dimension(220, 90));
        logout.setPreferredSize(new java.awt.Dimension(220, 90));
        logout.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jLabel5.setText("Log out");
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        logout.add(jLabel5, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sidebarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sidebarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        navbar.setBackground(new java.awt.Color(254, 253, 237));
        navbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        navbar.setMaximumSize(new java.awt.Dimension(125, 90));
        navbar.setMinimumSize(new java.awt.Dimension(125, 90));
        navbar.setPreferredSize(new java.awt.Dimension(165, 90));
        navbar.setLayout(new javax.swing.BoxLayout(navbar, javax.swing.BoxLayout.LINE_AXIS));

        tabTitle.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        tabTitle.setForeground(new java.awt.Color(161, 195, 152));
        tabTitle.setText("Dashboard");
        navbar.add(tabTitle);

        tabContainer.setBackground(new java.awt.Color(254, 253, 237));
        tabContainer.setMaximumSize(new java.awt.Dimension(1080, 610));
        tabContainer.setMinimumSize(new java.awt.Dimension(1080, 610));
        tabContainer.setPreferredSize(new java.awt.Dimension(1080, 610));
        tabContainer.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sidebarItemHover(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sidebarItemHover
        // TODO add your handling code here:
    }//GEN-LAST:event_sidebarItemHover

    private void dashboardNavItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardNavItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardNavItemMouseClicked

    private void appointementsNavItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointementsNavItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_appointementsNavItemMouseClicked

    private void patientsNavItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsNavItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patientsNavItemMouseClicked

    private void testsNavItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testsNavItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_testsNavItemMouseClicked

    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        nav.setActive("dashboard");
        tabTitle.setText("Dashboard");
        tabContainer.removeAll();
        tabContainer.add(Dashboard.getInstance(), BorderLayout.CENTER);
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void appointementsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointementsLabelMouseClicked
        // TODO add your handling code here:
        nav.setActive("appointements");
        tabTitle.setText("Appointments");
        tabContainer.removeAll();
        tabContainer.add(Appoint.getInstance(), BorderLayout.CENTER);
    }//GEN-LAST:event_appointementsLabelMouseClicked

    private void dashboardNavItemAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dashboardNavItemAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardNavItemAncestorRemoved

    private void patientsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsLabelMouseClicked
        // TODO add your handling code here:
        nav.setActive("patients");
        tabTitle.setText("Patients");
        tabContainer.removeAll();
        tabContainer.add(Patients.getInstance(), BorderLayout.CENTER);
    }//GEN-LAST:event_patientsLabelMouseClicked

    private void testsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testsLabelMouseClicked
        // TODO add your handling code here:
        nav.setActive("tests");
        tabTitle.setText("Tests");
        tabContainer.removeAll();
        tabContainer.add(Tests.getInstance(), BorderLayout.CENTER);
    }//GEN-LAST:event_testsLabelMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        dispose();
        // HibernateUtil.shutdown();
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LayoutFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointementsLabel;
    private javax.swing.JPanel appointementsNavItem;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JPanel dashboardNavItem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel patientsLabel;
    private javax.swing.JPanel patientsNavItem;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel sidebarMenu;
    private javax.swing.JPanel tabContainer;
    private javax.swing.JLabel tabTitle;
    private javax.swing.JLabel testsLabel;
    private javax.swing.JPanel testsNavItem;
    // End of variables declaration//GEN-END:variables
}
