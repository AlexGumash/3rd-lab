package dao;

import models.Evstudent;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EvstudentDao {


    public Evstudent findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Evstudent.class, id);
    }

    public Evstudent findByPhone(String name, String surname, String phone) {
        return (Evstudent) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Evstudent st WHERE st.name = :name AND st.surname = :surname AND st.phone = :phone")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("phone", phone)
                .uniqueResult();
    }

    public Evstudent findByEmail(String name, String surname, String email) {
        return (Evstudent) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Evstudent st WHERE st.name = :name AND st.surname = :surname AND st.email = :email")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("email", email)
                .uniqueResult();
    }

    public int save(Evstudent evstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        int savedId = (int) session.save(evstudent);
        tx1.commit();
        session.close();
        return savedId;
    }

    public void update(Evstudent evstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(evstudent);
        tx1.commit();
        session.close();
    }

    public void delete(Evstudent evstudent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(evstudent);
        tx1.commit();
        session.close();
    }


    public List<Evstudent> findAll() {
        List<Evstudent> evstudents = (List<Evstudent>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Evstudent").list();
        return evstudents;
    }
}
