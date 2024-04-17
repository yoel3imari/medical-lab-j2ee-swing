package com.mycompany.medicallab;

import com.mycompany.medicallab.views.LoginFrame;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MedicalLab {

    public static void main(String[] args) {
        // init db connection

        // Connection db = Database.getInstance().getConnection();
        // start login frame
        LoginFrame login = new LoginFrame();
        // redirect to dashboard
    }

}
