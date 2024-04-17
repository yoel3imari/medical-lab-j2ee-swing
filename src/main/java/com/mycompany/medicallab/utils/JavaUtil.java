package com.mycompany.medicallab.utils;

import javax.swing.*;

public class JavaUtil {

    public static void fireError(Exception ex ) {
        ex.printStackTrace();
        JFrame error = new JFrame("Connection Error");
        error.setSize(500, 300);
        JOptionPane.showMessageDialog(
                error,
                "Error: " + ex.getMessage() + " Not Found",
                "Driver Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

}
