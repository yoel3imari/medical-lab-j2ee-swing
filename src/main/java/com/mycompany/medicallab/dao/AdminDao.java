package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.models.Admin;
import com.mycompany.medicallab.utils.JavaUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AdminDao {

    public boolean validateAdminPassword(String enteredPassword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Create HQL query to retrieve the admin by username
            Query<Admin> query = session.createQuery("FROM Admin WHERE username = :username", Admin.class);
            query.setParameter("username", "admin");
            Admin admin = query.uniqueResult();

            if (admin != null) {
                String storedPassword = admin.getPassword();

                // Check if the entered password matches the stored password
                return storedPassword != null && storedPassword.equals(enteredPassword);
            }
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
        return false;
    }
}