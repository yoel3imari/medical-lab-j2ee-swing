package com.mycompany.medicallab;

import com.mycompany.medicallab.views.LoginFrame;

/**
 *
 * @author yusef
 */
public class MedicalLab {

    public static void main(String[] args) {
        // init db connection
        Database.connection();
        // start login frame
        LoginFrame login = new LoginFrame();
        // redirect to dashboard
    }

}
