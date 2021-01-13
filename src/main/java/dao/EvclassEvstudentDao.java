package dao;

import models.Application;
import models.EvclassEvstudent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EvclassEvstudentDao {

    public EvclassEvstudent findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EvclassEvstudent.class, id);
    }

    public List<EvclassEvstudent> findByClass(int classId, int studentId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EvclassEvstudent cs WHERE cs.evclassId = :classId AND cs.evstudentId = :studentId")
                .setParameter("classId", classId)
                .setParameter("studentId", studentId)
                .list();
    }

    public void save(EvclassEvstudent evclassEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(evclassEvstudent);
        tx1.commit();
        session.close();
    }

    public void update(EvclassEvstudent evclassEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(evclassEvstudent);
        tx1.commit();
        session.close();
    }

    public void delete(EvclassEvstudent evclassEvstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(evclassEvstudent);
        tx1.commit();
        session.close();
    }


    public List<EvclassEvstudent> findAll() {
        List<EvclassEvstudent> evclassEvstudents = (List<EvclassEvstudent>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EvclassEvstudent").list();
        return evclassEvstudents;
    }
}
