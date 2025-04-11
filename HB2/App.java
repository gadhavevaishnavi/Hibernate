package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee1;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure(); // load All configuration
		SessionFactory sf = con.buildSessionFactory(); // common for all hence thread-safe //(create once and reuse)
														// hold database connection (immutable)
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee1 e = new Employee1();
		e.setName("Aamambabai ");
		e.setCompany("TCS");
		e.setDesignation("UI Developer");
		e.setSalary(1700000);
		
		session.save(e);
		tx.commit();
		session.close();   
		/*
		 +----+-------------------+----------------+-----------+---------+
| id | name              | designation    | company   | salary  |
+----+-------------------+----------------+-----------+---------+
|  1 | Vaishnavi Gadhave | Java Developer | Microsoft | 1700000 |
|  2 | Aamambabai        | UI Developer   | TCS       | 1700000 |
+----+-------------------+----------------+-----------+---------+
2 rows in set (0.00 sec)
		 */
		
	}
}
