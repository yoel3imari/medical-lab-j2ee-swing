/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.dao;

import com.mycompany.medicallab.models.Test;
import com.mycompany.medicallab.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
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
        String sql = "INSERT INTO tests (label, price, days_to_get_result, description, type) " +
                     "VALUES (:label, :price, :daysToGetResult, :description, :type)";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createQuery(sql)
                    .setParameter("label", test.getLabel())
                    .setParameter("price", test.getPrice())
                    .setParameter("daysToGetResult", test.getDaysToGetResult())
                    .setParameter("description", test.getDescription())
                    .setParameter("type", test.getType());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public void updateTest(Test test) {
        String sql = "UPDATE tests SET label = :label, price = :price, " +
                     "days_to_get_result = :daysToGetResult, description = :description, " +
                     "type = :type WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query query = session.createQuery(sql)
                    .setParameter("label", test.getLabel())
                    .setParameter("price", test.getPrice())
                    .setParameter("daysToGetResult", test.getDaysToGetResult())
                    .setParameter("description", test.getDescription())
                    .setParameter("type", test.getType())
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

            Query query = session.createQuery(sql)
                    .setParameter("id", test.getId());
            query.executeUpdate();

            commitTransaction(session);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Test getTestById(Long id) {
        String sql = "FROM Test WHERE id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            beginTransaction(session);

            Query<Test> query = session.createQuery(sql, Test.class)
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
    String sql = "SELECT * FROM tests";

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
}

