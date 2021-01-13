package dao;

import models.Evcourse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EvcourseDao {

    public Evcourse findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Evcourse.class, id);
    }

    public void save(Evcourse evcourse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(evcourse);
        tx1.commit();
        session.close();
    }

    public void update(Evcourse evcourse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(evcourse);
        tx1.commit();
        session.close();
    }

    public void delete(Evcourse evcourse) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(evcourse);
        tx1.commit();
        session.close();
    }


    public List<Evcourse> findAll() {
        List<Evcourse> evcourses = (List<Evcourse>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Evcourse").list();
        return evcourses;
    }
}
