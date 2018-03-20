package test.hibernate.main;

import org.hibernate.Session;

import test.hibernate.dao.PersonDAO;
import test.hibernate.entity.Person;
import test.hibernate.util.HibernateUtil;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            PersonDAO personDAO = new PersonDAO(session);
            Person person = new Person("Ema", "White", "address");
            personDAO.addPerson(person);
            person = new Person("Lena", "Mair", "address 2");
            personDAO.addPerson(person);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
