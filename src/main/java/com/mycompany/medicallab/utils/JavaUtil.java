package com.mycompany.medicallab.utils;

import java.time.LocalTime;
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
    
    public static LocalTime regulateTime(LocalTime time) {
        // get minutes
        // divide by 15
        // add till rest is 
        int minutes = time.getMinute();
        System.out.println("minutes => " + minutes);
        if( minutes == 0 ) return time;
        return time.minusMinutes(minutes%15);
        
    }
    
    public static int regulateDuration(int minutes) {
        return minutes + 15 - 15%minutes;
    }
    
    public static void main(String[] args) {
        System.out.print("18:55 => " + regulateTime(LocalTime.of(18, 55)));
        System.out.print("18:09 => " + regulateTime(LocalTime.of(18, 9)));
        System.out.print("18:18 => " + regulateTime(LocalTime.of(18, 18)));
        System.out.print("18:42 => " + regulateTime(LocalTime.of(18, 42)));
        
    }

}
