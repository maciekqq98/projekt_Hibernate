package com.company;

import Model.WynikiEntity;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        WynikiEntity wynikiEntity = session.get(WynikiEntity.class, 1);
        session.getTransaction().commit();
        session.close();




    }
}
