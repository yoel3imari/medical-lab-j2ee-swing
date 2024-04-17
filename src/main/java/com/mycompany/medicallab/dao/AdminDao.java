package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.models.Admin;
import com.mycompany.medicallab.utils.JavaUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AdminDao {

    public boolean validateAdminPassword(String enteredPassword) {
        System.out.println("password: " + enteredPassword);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Query<Admin> query = session.createQuery("FROM Admin a WHERE username = :username", Admin.class);
            query.setParameter("username", "admin");
            Admin admin = query.uniqueResult();

            if (admin != null) {
                String storedPassword = admin.getPassword();

                // Check if the entered password matches the stored password
                return storedPassword != null && storedPassword.equals(enteredPassword);
            }
            
            session.getTransaction().commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
        return false;
    }
}