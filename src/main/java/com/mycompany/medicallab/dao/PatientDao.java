package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PatientDao {

    public void savePatient(Patient patient) {
        String sql = 
                "INSERT INTO Patient (fName, lName, cin, email, phone, gender, birthdate) " 
                    +
                "VALUES (:fName, :lName, :cin, :email, :phone, :gender, :birthdate)";
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
             
            Query query = session.createQuery(sql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender())
                    .setParameter("birthdate", patient.getBirthdate())
                    .setParameter("id", patient.getId());
            query.executeUpdate();
            
            transaction.commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    public void updatePatient(Patient patient) {
        
        String sql = 
                "UPDATE Patient SET fName = :fName, lName = :lName, cin = :cin, email = :email, "
                + 
                "phone = :phone, gender = :gender, birthdate = :birthdate WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            
            Query query = session.createQuery(sql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender())
                    .setParameter("birthdate", patient.getBirthdate())
                    .setParameter("id", patient.getId());
            query.executeUpdate();
            
            transaction.commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    public void deletePatient(Patient patient) {
        String sql = "DELETE FROM Patient WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery(sql)
                    .setParameter("id", patient.getId());
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
}

    public Patient getPatientById(Long id) {
        String sql = "FROM Patient WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            
            Query<Patient> query = session.createQuery(sql, Patient.class)
                    .setParameter("id", id);
            Patient patient = query.uniqueResult();
            
            transaction.commit();
            return patient;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public List<Patient> getAllPatients() {
    String sql = "FROM Patient";

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        
        Query<Patient> query = session.createQuery(sql, Patient.class);
        List<Patient> patients = query.list();
        
        transaction.commit();
        return patients;
    } catch (Exception e) {
        JavaUtil.fireError(e);
        return null;
    }
}
}

