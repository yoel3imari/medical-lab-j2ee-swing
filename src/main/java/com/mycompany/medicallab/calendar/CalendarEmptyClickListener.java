package com.mycompany.medicallab.calendar;

import java.util.EventListener;

public interface CalendarEmptyClickListener extends EventListener {
    // Event dispatch methods
    void calendarEmptyClick(CalendarEmptyClickEvent e);
}
