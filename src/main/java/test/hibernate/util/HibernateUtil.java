package test.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import test.hibernate.entity.Person;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            Configuration aconf = new AnnotationConfiguration().
                    addAnnotatedClass(Person.class);
            aconf.configure();
        } catch (Throwable e) {
            // make sure you log the exception, as it might be swallowedHibernate
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}