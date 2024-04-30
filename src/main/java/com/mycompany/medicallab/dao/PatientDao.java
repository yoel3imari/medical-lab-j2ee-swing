package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Patient;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PatientDao {

    public boolean savePatient(Patient patient) {
        // here notice that i did not enter the correct bale name which is patients but the model name Patient 
        String hql
                = "INSERT INTO Patient (fName, lName, cin, email, phone, gender, birthdate) "
                + "VALUES (:fName, :lName, :cin, :email, :phone, :gender, :birthdate)";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery(hql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender())
                    .setParameter("birthdate", patient.getBirthdate());
            //.setParameter("gender", patient.getGender().name())
            query.executeUpdate();

            // another easy way of adding Patient without all the code above.
            // also there is a similar way to do it for update and delete functions bellow 
            //session.save(patient);
            session.getTransaction().commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
        return true;
    }

    public boolean updatePatient(Patient patient) {
        String hql = "UPDATE Patient SET fName = :fName, lName = :lName, cin = :cin, email = :email, "
                + "phone = :phone, gender = :gender, birthdate = :birthdate WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery(hql)
                    .setParameter("fName", patient.getfName())
                    .setParameter("lName", patient.getlName())
                    .setParameter("cin", patient.getCin())
                    .setParameter("email", patient.getEmail())
                    .setParameter("phone", patient.getPhone())
                    .setParameter("gender", patient.getGender())
                    .setParameter("birthdate", patient.getBirthdate())
                    .setParameter("id", patient.getId());
            //.setParameter("gender", patient.getGender().name())
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
        return true;
    }

    public boolean deletePatient(Patient patient) {
        String hql = "DELETE FROM Patient WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery(hql)
                    .setParameter("id", patient.getId());
            int rowCount = query.executeUpdate();

            session.getTransaction().commit();
            // Check if any rows were affected (deleted)
            return rowCount > 0;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
    }

    public Patient getPatientById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Patient> query = session.createQuery("FROM Patient WHERE id = :id", Patient.class)
                    .setParameter("id", id);
            Patient patient = query.uniqueResult();

            session.getTransaction().commit();
            return patient;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public Patient getPatientByCIN(String cin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<Patient> query = session.createQuery("FROM Patient WHERE cin = :cin", Patient.class);
            query.setParameter("cin", cin);
            Patient patient = query.uniqueResult();

            session.getTransaction().commit();

            return patient;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patients order by created_at";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createNativeQuery(sql, Patient.class);
            List<Patient> patients = query.list();

            session.getTransaction().commit();
            return patients;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public boolean patientExists(String cin) {
        Patient p = getPatientByCIN(cin);
        return p != null;
    }

}
