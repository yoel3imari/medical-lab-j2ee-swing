package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Appointment;
import com.mycompany.medicallab.utils.AptState;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import com.mycompany.medicallab.utils.NotificationUtil;
import com.mycompany.medicallab.views.tabs.Appoint;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.NativeQuery;

public class AppointmentDao {

    /**
     *  Save a new appointment to databse
     * @param appoint
     * @return 
     */
    public boolean saveAppoint(Appointment appoint) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            Query<?> q = session.createNativeQuery("""
                INSERT INTO appointments (day, hour, state, patient_id, test_id)
                values (:day, :hour, :state, :patient_id, :test_id)
            """, Appointment.class);
            q.setParameter("day", appoint.getDay());
            q.setParameter("hour", appoint.getHour());
            q.setParameter("state", appoint.getState());
            q.setParameter("patient_id", appoint.getPatient().getId());
            q.setParameter("test_id", appoint.getTest().getId());
            int rowCount = q.executeUpdate();
            session.getTransaction().commit();

            return rowCount > 0;

        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
    }

    /**
     * update existing appointment
     * @param appoint
     * @return 
     */
    public boolean updateAppoint(Appointment appoint) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("""
                    update appointments
                    set patient=:patient, day=:day, hour=:hour, state=:state, updatedAt=:updated_at 
                    where id=:id
            """, Appointment.class);
            query.setParameter("id", appoint.getId());
            query.setParameter("patient", appoint.getPatient());
            query.setParameter("day", appoint.getDay());
            query.setParameter("hour", appoint.getHour());
            query.setParameter("state", appoint.getState());
            query.setParameter("updated_at", LocalDateTime.now());
            int rowCount = query.executeUpdate();
            session.getTransaction().commit();
            return rowCount > 0;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
    }

    /**
     * mark an appointment as AptState.CANCELED
     * @param apt
     * @return 
     */
    public boolean deleteAppoint(Appointment apt) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("UPDATE appointments SET state = :state WHERE id = :id", Appointment.class);
            query.setParameter("state", AptState.CANCELED);
            query.setParameter("id", apt.getId());
            int rowCount = query.executeUpdate();
            session.getTransaction().commit();
            return rowCount > 0;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
    }

    /**
     * retrieve appointment by ID
     * @param id
     * @return 
     */
    public Appointment getAppointById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("select * from appointments where id = :id", Appointment.class);
            query.setParameter("id", id);
            Appointment appointment = (Appointment) query.uniqueResult();
            session.getTransaction().commit();
            return appointment;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    /**
     * retrieve an appointementby Date and Hour
     * @param date
     * @param hour
     * @return 
     */
    public Appointment getAppointByDateHour(LocalDate date, LocalTime hour) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("from appointments where day=:day and hour=:hour and state=:state", Appointment.class);
            query.setParameter("day", date);
            query.setParameter("hour", hour);
            query.setParameter("state", AptState.PENDING);
            Appointment apt = (Appointment) query.uniqueResult();
            session.getTransaction().commit();
            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    /**
     * retrieve appointments of a certain day
     * @param date
     * @return 
     */
    public List<Appointment> getAppointByDate(LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("select * from appointments where day=:day and state = :state", Appointment.class);
            query.setParameter("day", date);
            query.setParameter("state", AptState.PENDING);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();
            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    /**
     * retrieve appointments between two dates
     * @param from
     * @param to
     * @return 
     */
    public List<Appointment> getAppointBetween(LocalDate from, LocalDate to) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Appointment> query = session.createNativeQuery("select * from appointments where state = :state and day between :from and :to order by day, hour", Appointment.class);
            query.setParameter("from", from);
            query.setParameter("state", AptState.PENDING);
            query.setParameter("to", to);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();

            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    /**
     * get the date of the last appointment chronologically
     * @return 
     */
    public LocalDate getLastAppointDate() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Appointment> query = session.createNativeQuery(
                    """
                SELECT *
                FROM appointments
                WHERE day = (
                    SELECT MAX(day)
                    FROM appointments
                    WHERE state=:state
                );
            """, Appointment.class);
            query.setParameter("state", AptState.PENDING);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();
            
            if( apt == null || apt.isEmpty() ) {
                return LocalDate.now();
            }
            
            return apt.get(0).getDay();
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }
    
    /**
     * get today's appointments
     * @return 
     */
    public List<Appointment> getTodaysAppointments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("""
                SELECT *
                FROM appointments
                WHERE `day` = CURDATE()
                  AND `state` = :state
                  AND (HOUR(`hour`) > HOUR(CURTIME()) OR (HOUR(`hour`) = HOUR(CURTIME()) AND MINUTE(`hour`) >= MINUTE(CURTIME())))
                ORDER BY HOUR(`hour`), MINUTE(`hour`);
            """, Appointment.class);
            query.setParameter("state", AptState.PENDING);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();
            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }
}

