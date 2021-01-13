package dao;

import models.Application;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ApplicationDao {

    public Application findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Application.class, id);
    }

    public List<Application> findByFullNameAndEmail(String name, String surname, String email) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Application app WHERE app.name = :name AND app.surname = :surname AND app.email = :email")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("email", email)
                .list();
    }

    public void save(Application application) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(application);
        tx1.commit();
        session.close();
    }

    public void update(Application application) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(application);
        tx1.commit();
        session.close();
    }

    public void delete(Application application) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(application);
        tx1.commit();
        session.close();
    }


    public List<Application> findAll() {
        List<Application> applications = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Application").list();
        return applications;
    }
}
