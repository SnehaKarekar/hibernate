package com.hql1;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {
	public static void main(String[] args) {
		
		Configuration config=new Configuration().configure("hql1.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf=config.buildSessionFactory(sr);
		
//		Student s1=new Student();
//		s1.setStudent_id(2);
//		s1.setName("bhavana");
//		
//		Student s2=new Student();
//		s2.setStudent_id(4);
//		s2.setName("namrata");
		
		Session session=sf.openSession();
		
		//for unique result
//		String qry="from Student where id=2";
//		Query student=session.createQuery(qry);
//		Object o=student.uniqueResult();
//		System.out.println(o);
		
		//for all the list
		String studentQry="from Student";
		Query q=session.createQuery(studentQry);
		List<Student> listStudents=q.list();
		for(Student s:listStudents)
		{
			System.out.println(s);
		}
		
		//delete a particular record
		String deleteQry="delete from Student as s where s.id=:c";
		Query delete=session.createQuery(deleteQry);
		delete.setParameter("c", 2);
		delete.executeUpdate();
		List<Student> listStudents1=q.list();
		for(Student s1:listStudents1)
		{
			System.out.println(s1);
		}
		
//		Transaction transaction=session.beginTransaction();
//		session.save(s1);
//		session.save(s2);
//		transaction.commit();
		
		session.close();
	}
}
