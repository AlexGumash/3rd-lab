package dao;

import models.Evclass;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EvclassDao {

    public Evclass findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Evclass.class, id);
    }

    public void save(Evclass evclass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(evclass);
        tx1.commit();
        session.close();
    }

    public void update(Evclass evclass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(evclass);
        tx1.commit();
        session.close();
    }

    public void delete(Evclass evclass) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(evclass);
        tx1.commit();
        session.close();
    }


    public List<Evclass> findAll() {
        List<Evclass> evclasses = (List<Evclass>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Evclass").list();
        return evclasses;
    }
}
