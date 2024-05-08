package com.mycompany.medicallab.utils;

import com.mycompany.medicallab.calendar.Week;
import com.mycompany.medicallab.dao.AppointmentDao;
import com.mycompany.medicallab.models.Appointment;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class JavaUtil {

    public static void fireError(Exception ex) {
        JFrame frame = new JFrame("Error");
        frame.setSize(500, Integer.MAX_VALUE);
        JTextArea textArea = new JTextArea(ex.getMessage());
        textArea.setSize(400, Integer.MAX_VALUE);
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

    /**
     * round time to 00 or 30 minutes
     * @param datetime time to be rounded
     * @return 
     */
    public static LocalDateTime regulateDateTime(LocalDateTime datetime) {
        
        int minutes = datetime.getMinute();
        System.out.println("minutes => " + minutes);
        if (minutes == 0) {
            return datetime;
        }
        return datetime.minusMinutes(minutes % 30);
    }

    /**
     * if test duration is less or more than 30mins
     * @param minutes if < 30 => 30 ; if > 30 => 00
     * @return 
     */
    public static int regulateDuration(int minutes) {
        //int rest = minutes % 30;
        return minutes + (30 - (minutes % 30));
    }

    /**
     * return the exact date of the next saturday
     * useful to get appointments between monday and saturday
     * @param today
     * @return 
     */
    public static LocalDate getNextSaturday(LocalDate today) {
        LocalDate nextSaturday = today;
        while (nextSaturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
            nextSaturday = nextSaturday.plusDays(1);
        }

        return nextSaturday;
    }

    /**
     * debug code
     * @param obj 
     */
    public static void DumpPeek(Object obj) {

        if (obj instanceof List) {
            ((List) obj).forEach(e -> {
                System.out.println("-------------------------------");
                System.err.println("Var: " + e.toString());
                System.out.println("-------------------------------");
            });
        } else {
            System.out.println("-------------------------------");
            System.err.println("Var: " + obj.toString());
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(15);
        l.add(20);

        Integer x = l.get(0);
        l.remove(0);
        System.out.println(x);
        System.out.println(l);
    }

}
