package com.mycompany.medicallab;

import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.views.LoginFrame;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MedicalLab {

    public static void main(String[] args) {
        // open new hibernate session
        HibernateUtil.getSessionFactory().openSession();
        // start with login
        LoginFrame login = new LoginFrame();
    }

}
