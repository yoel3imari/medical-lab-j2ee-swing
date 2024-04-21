package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PatientDao {

    private void beginTransaction(Session session) {
        session.beginTransaction();
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    public void savePatient(Patient patient) {
        // here notice that i did not enter the correct bale name which is patients but the model name Patient 
        String hql =
                "INSERT INTO Patient (fName, lName, cin, email, phone, gender, birthdate) " 
                +
                "VALUES (:fName, :lName, :cin, :email, :phone, :gender, :birthdate)";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createQuery(hql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender().name())
                    .setParameter("birthdate", patient.getBirthdate());
            query.executeUpdate();
            
            // another easy way of adding Patient without all the code above.
            // also there is a similar way to do it for update and delete functions bellow 
            //session.save(patient);
            commitTransaction(session);
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    public void updatePatient(Patient patient) {
        String hql =
                "UPDATE Patient SET fName = :fName, lName = :lName, cin = :cin, email = :email, " 
                +
                "phone = :phone, gender = :gender, birthdate = :birthdate WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createQuery(hql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender().name())
                    .setParameter("birthdate", patient.getBirthdate())
                    .setParameter("id", patient.getId());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    public void deletePatient(Patient patient) {
        String hql = "DELETE FROM Patient WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createQuery(hql)
                    .setParameter("id", patient.getId());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }

    public Patient getPatientById(Long id) {
        String hql = "FROM Patient WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query<Patient> query = session.createQuery(hql, Patient.class)
                    .setParameter("id", id);
            Patient patient = query.uniqueResult();

            commitTransaction(session);
            return patient;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public List<Patient> getAllPatients() {
        String hql = "FROM Patient";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query<Patient> query = session.createQuery(hql, Patient.class);
            List<Patient> patients = query.list();

            commitTransaction(session);
            return patients;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }
}
