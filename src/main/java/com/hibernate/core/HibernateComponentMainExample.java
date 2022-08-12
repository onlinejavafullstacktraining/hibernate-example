package com.hibernate.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateComponentMainExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addResource("user.hbm.xml");
                //.addClass(User.class);
        //      .addClass(Message.class);
        // when we use addClass method the hbm file should be in available in same folder.
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Component Example

        Address homeAddress =new Address();
        homeAddress.setCity("Hyderabad");
        homeAddress.setZipcode("500016");
        homeAddress.setStreet("Hi-tech city");

        Address billingAddress=new Address();
        billingAddress.setStreet("MG Road");
        billingAddress.setZipcode("560001");
        billingAddress.setCity("Bangalore");

        Person person =new Person();
        person.setUsername("Ram Kumar");
        person.setBillingAddress(billingAddress);
        person.setHomeAddress(homeAddress);

        session.saveOrUpdate(person);
        tx.commit();
        session.close();
    }
}
