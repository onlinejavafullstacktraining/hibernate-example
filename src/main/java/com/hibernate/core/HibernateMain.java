package com.hibernate.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        /* Connecting Database through to hibernate */
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Message message = new Message("Hello World");
        session.save(message);
        tx.commit();
        session.close();
    }
}
