package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Appointment;
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

public class AppointmentDao {

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

    public boolean deleteAppoint(Appointment apt) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("delete from appointments where id=:id", Appointment.class);
            query.setParameter("id", apt.getId());
            int rowCount = query.executeUpdate();
            session.getTransaction().commit();
            return rowCount > 0;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return false;
        }
    }

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

    public Appointment getAppointByDateHour(LocalDate date, LocalTime hour) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("from appointments where day=:day and hour=:hour", Appointment.class);
            query.setParameter("day", date);
            query.setParameter("hour", hour);
            Appointment apt = (Appointment) query.uniqueResult();
            session.getTransaction().commit();
            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public List<Appointment> getAppointByDate(LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createNativeQuery("from appointments where day=:day", Appointment.class);
            query.setParameter("day", date);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();
            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public List<Appointment> getAppointBetween(LocalDate from, LocalDate to) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Appointment> query = session.createNativeQuery("select * from appointments where day between :from and :to order by day, hour", Appointment.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();

            return apt;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

    public LocalDate getLastAppointDate() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Appointment> query = session.createNativeQuery(
                    """
                SELECT *
                FROM appointments
                WHERE (day, hour) = (
                    SELECT day, MAX(hour)
                    FROM appointments
                    WHERE day = (
                        SELECT MAX(day)
                        FROM appointments
                    )
                    GROUP BY day
                );
            """, Appointment.class);
            List<Appointment> apt = query.getResultList();
            session.getTransaction().commit();
            return apt.get(0).getDay();
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

}
