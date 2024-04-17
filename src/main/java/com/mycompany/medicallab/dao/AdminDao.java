package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.models.Admin;
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
                // Compare entered password with the password retrieved from database
                return admin.getPassword().equals(enteredPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}