package dao;

import models.Application;
import models.SeminarEvstudent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SeminarEvstudentDao {

    public SeminarEvstudent findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(SeminarEvstudent.class, id);
    }

    public void save(SeminarEvstudent seminarEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(seminarEvstudent);
        tx1.commit();
        session.close();
    }

    public void update(SeminarEvstudent seminarEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(seminarEvstudent);
        tx1.commit();
        session.close();
    }

    public void delete(SeminarEvstudent seminarEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(seminarEvstudent);
        tx1.commit();
        session.close();
    }


    public List<SeminarEvstudent> findAll() {
        List<SeminarEvstudent> seminarEvstudents = (List<SeminarEvstudent>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From SeminarEvstudent").list();
        return seminarEvstudents;
    }
}
