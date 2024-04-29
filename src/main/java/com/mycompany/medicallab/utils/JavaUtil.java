package com.mycompany.medicallab.utils;

import com.mycompany.medicallab.dao.AppointmentDao;
import com.mycompany.medicallab.models.Appointment;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.swing.*;

public class JavaUtil {

    public static void fireError(Exception ex) {
        JFrame frame = new JFrame("Error");
        frame.setSize(500, 300);
        JTextArea textArea = new JTextArea(ex.getMessage());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JOptionPane.showMessageDialog(
                frame,
                textArea,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static LocalTime regulateTime(LocalTime time) {
        // get minutes
        // divide by 30
        // add till rest is 
        int minutes = time.getMinute();
        System.out.println("minutes => " + minutes);
        if (minutes == 0) {
            return time;
        }
        return time.minusMinutes(minutes % 30);

    }
    
    public static LocalDateTime regulateDateTime(LocalDateTime datetime) {
        // get minutes
        // divide by 30
        // add till rest is 
        int minutes = datetime.getMinute();
        System.out.println("minutes => " + minutes);
        if (minutes == 0) {
            return datetime;
        }
        return datetime.minusMinutes(minutes % 30);

    }
    
    

    public static int regulateDuration(int minutes) {
        return minutes + 30 - 30 % minutes;
    }

    public static LocalDate getNextSaturday(LocalDate today) {
        LocalDate nextSaturday = today;
        while (nextSaturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
            nextSaturday = nextSaturday.plusDays(1);
        }

        return nextSaturday;
    }

    public static void DumpPeek(Object obj) {

        if (obj instanceof List) {
            ((List) obj).forEach(e -> {
                System.out.println("-------------------------------");
                System.err.println("Var: " + e.toString());
                System.out.println("-------------------------------");
            });
        }

        System.out.println("-------------------------------");
        System.err.println("Var: " + obj.toString());
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {}

}
