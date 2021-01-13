package dao;

import models.Seminar;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SeminarDao {

    public Seminar findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Seminar.class, id);
    }

    public void save(Seminar seminar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(seminar);
        tx1.commit();
        session.close();
    }

    public void update(Seminar seminar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(seminar);
        tx1.commit();
        session.close();
    }

    public void delete(Seminar seminar) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(seminar);
        tx1.commit();
        session.close();
    }


    public List<Seminar> findAll() {
        List<Seminar> seminars = (List<Seminar>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Seminar").list();
        return seminars;
    }
}

