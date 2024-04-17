package com.mycompany.medicallab.utils;

import javax.swing.*;

public class JavaUtil {

    public static void fireError(Exception ex ) {
        JFrame frame = new JFrame("Error");
        frame.setSize(500, 300);
        JOptionPane.showMessageDialog(
                frame,
                "Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

}
