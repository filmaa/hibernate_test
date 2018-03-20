package test.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import test.hibernate.entity.Person;

public class PersonDAO {
    private Session session;

    public PersonDAO(Session session) {
        this.session = session;
    }

    public Person getPerson(int id) {
        Person person = null;
        try {
            Query query = session.getNamedQuery("findPersonById");
            query.setParameter("id", id);
            person = (Person) query.uniqueResult();
            System.out.println(person.toString());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void addPerson(Person person) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
