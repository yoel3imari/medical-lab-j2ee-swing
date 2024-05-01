/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Test;
import com.mycompany.medicallab.utils.HibernateUtil;
import com.mycompany.medicallab.utils.JavaUtil;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author ELyazid
 */
public class TestDao {

    private void beginTransaction(Session session) {
        session.beginTransaction();
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    public void saveTest(Test test) {
        String sql = "INSERT INTO tests (label, price,duration, days_to_get_result, description) "
                + "VALUES (:label, :price, :duration, :daysToGetResult, :description)";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createNativeQuery(sql)
                    .setParameter("label", test.getLabel())
                    .setParameter("price", test.getPrice())
                    .setParameter("duration", test.getDuration())
                    .setParameter("daysToGetResult", test.getDaysToGetResult())
                    .setParameter("description", test.getDescription());

            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public void updateTest(Test test) {
        String sql = "UPDATE tests SET label = :label, price = :price, duration = :duration, "
                + "days_to_get_result = :daysToGetResult, description = :description "
                + "WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createNativeQuery(sql)
                    .setParameter("label", test.getLabel())
                    .setParameter("price", test.getPrice())
                    .setParameter("duration", test.getDuration())
                    .setParameter("daysToGetResult", test.getDaysToGetResult())
                    .setParameter("description", test.getDescription())
                    .setParameter("id", test.getId());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public void deleteTest(Test test) {
        String sql = "DELETE FROM tests WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createNativeQuery(sql)
                    .setParameter("id", test.getId());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Test getTestById(int id) {
        String sql = "SELECT * FROM tests WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query<Test> query = session.createNativeQuery(sql, Test.class)
                    .setParameter("id", id);
            Test test = query.uniqueResult();

            commitTransaction(session);
            return test;
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    public List<Test> getAllTests() {
        String sql = "SELECT * FROM tests order by created_at DESC";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createNativeQuery(sql, Test.class);
            List<Test> tests = query.list();

            commitTransaction(session);
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Test> searchTests(String keyword) {
        String sql = "FROM Test t WHERE CAST(t.id AS string) LIKE :keyword OR t.description LIKE :keyword OR CAST(t.price AS string) LIKE :keyword";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query<Test> query = session.createQuery(sql, Test.class)
                    .setParameter("keyword", "%" + keyword + "%");
            List<Test> tests = query.getResultList();

            commitTransaction(session);
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public List<Object[]> getTodaysTestsAndCounts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            String sqlQuery = "SELECT t.label AS test_label, COUNT(*) AS test_count " +
                              "FROM tests t " +
                              "JOIN appointments a ON t.id = a.test_id " +
                              "WHERE DATE(a.day) = CURDATE() " +
                              "GROUP BY t.label";

            NativeQuery<Object[]> query = session.createNativeQuery(sqlQuery);
            List<Object[]> results = query.getResultList();

            session.getTransaction().commit();

            return results;
        } catch (Exception e) {
            JavaUtil.fireError(e);
            return null;
        }
    }

}
