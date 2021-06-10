package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Company {
	public static void main(String[] args)
	{
		Configuration conf=new Configuration().configure("manytomany.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Projects.class);
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory(sr);
		
		Employee emp1=new Employee();
		emp1.setEmpid(1);
		emp1.setEmpname("sneha");
		Employee emp2=new Employee();
		emp2.setEmpid(2);
		emp2.setEmpname("bhavana");

		Projects pro1=new Projects(); 
		pro1.setProjname("overcurrent relay");
		pro1.setProjid(11);
		Projects pro2=new Projects(); 
		pro2.setProjname("matlab");
		pro2.setProjid(22);
		
		List<Employee> empList=new ArrayList<Employee>();
		List<Projects> proList=new ArrayList<Projects>();
		
		empList.add(emp1);
		empList.add(emp2);
		proList.add(pro1);
		proList.add(pro2);
		
		emp1.setProjects(proList);
		pro2.setEmp(empList);
		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		transaction.commit();
	}
}
