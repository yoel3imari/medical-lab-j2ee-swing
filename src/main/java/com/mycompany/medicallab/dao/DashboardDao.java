/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Appointment;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author dev23
 */
public class DashboardDao {
    public List<Object[]> getTodaysResults(){
        
        // this query works in mysql workbench but gives error with hibernate so i will use alternative synatx that is compatible with HQL
//        String hql = "SELECT p.fName, p.lName, p.cin, t.label, a.day, t.days_to_get_result, " +
//                         "DATE_ADD(a.day, INTERVAL t.days_to_get_result DAY) AS resultDay " +
//                         "FROM Appointment a " +
//                         "JOIN a.patient p " +
//                         "JOIN a.test t " +
//                         "WHERE DAYOFMONTH(DATE_ADD(a.day, INTERVAL t.days_to_get_result DAY)) = DAYOFMONTH(CURRENT_DATE())";

        String sql = "SELECT p.fName, p.lName, p.cin, t.label, a.day, t.days_to_get_result, " +
                         "DATE_ADD(a.day, INTERVAL t.days_to_get_result DAY) AS resultDay " +
                         "FROM appointments a " +
                         "JOIN patients p ON a.patient_id = p.id " +
                         "JOIN tests t ON a.test_id = t.id " +
                         "WHERE DAY(DATE_ADD(a.day, INTERVAL t.days_to_get_result DAY)) = DAY(CURRENT_DATE())";
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            NativeQuery<Object[]> query = session.createNativeQuery(sql);
            
            List<Object[]> results = query.list();

            session.getTransaction().commit();
            
            return results;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }
    
    public void endAppointmentById(Long id){
        String sql = """
                    UPDATE appointments SET state = :state WHERE id = :id
                    """;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createNativeQuery(sql)
                    .setParameter("state", "ended")
                    .setParameter("id", id);
            int x = query.executeUpdate();
            
            System.out.println("UPdate SQL status : "+ x);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            JavaUtil.fireError(e);
        }
    }
}
