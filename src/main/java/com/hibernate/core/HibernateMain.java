package com.hibernate.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        /* Connecting Database through to hibernate */

        /*Removed the hibernate.cfg.xml file from the Configuration class
         using the hibernate.properties file
        */
        Configuration configuration = new Configuration()
                .addResource("Message.hbm.xml");
        //      .addClass(Message.class);
        // when we use addClass method the hbm file should be in available in same folder.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Message message = new Message("Hibernate Properties");
        session.save(message);
        tx.commit();
        session.close();
    }
}
