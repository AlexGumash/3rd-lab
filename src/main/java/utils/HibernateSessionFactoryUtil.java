package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Evclass.class);
                configuration.addAnnotatedClass(EvclassEvstudent.class);
                configuration.addAnnotatedClass(Evcourse.class);
                configuration.addAnnotatedClass(Evstudent.class);
                configuration.addAnnotatedClass(Application.class);
                configuration.addAnnotatedClass(Seminar.class);
                configuration.addAnnotatedClass(SeminarEvstudent.class);

                if (System.getenv("DB_HOST") != null && System.getenv("DB_PORT") != null && System.getenv("DB_NAME") != null){
                    configuration.setProperty("hibernate.connection.url", "jdbc:db2://" + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME"));
                }
                if (System.getenv("DB_USER") != null){
                    configuration.setProperty("hibernate.connection.username", System.getenv("DB_USER"));
                }
                if (System.getenv("DB_PASSWORD") != null){
                    configuration.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
                }

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return sessionFactory;
    }
}
