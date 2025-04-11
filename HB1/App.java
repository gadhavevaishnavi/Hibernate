package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Student1;


public class App 
{
    public static void main( String[] args )
    {
       Configuration con =new Configuration().configure();
       SessionFactory sf = con.buildSessionFactory();
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       
       Student1 s1 = new Student1();
       s1.setName("Sejal");
       s1.setCity("Amaravati");
       s1.setPercentage(98.76);
       
       session.save(s1);  //insert
       
       tx.commit();
       session.close();
    }
}
