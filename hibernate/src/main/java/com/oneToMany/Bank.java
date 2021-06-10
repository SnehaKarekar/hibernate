package com.oneToMany;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Bank {
	public static void main(String[] args) throws IOException {
		Configuration conf=new Configuration().configure("onetomany.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Accounts.class);
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory(sr);
//		Person person=new Person();
//		person.setName("sneha");
//		
//		Accounts account1=new Accounts();
//		account1.setBankName("SBI");
//		Accounts account2=new Accounts();
//		account2.setBankName("BOM");
//		
//		List<Accounts> list=new ArrayList<Accounts>();
//		list.add(account1);
//		list.add(account2);
//		
//		person.setAccounts(list);
//		account1.setPerson(person);
//		account2.setPerson(person);
//		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
//		session.save(person);
//		session.save(account1);
//		session.save(account2);
		
		Person person=(Person)session.get(Person.class,1);
		for(Accounts a:person.getAccounts())
		{
			System.out.println(a.getAccountNum()+":"+a.getBankName()+":"+a.getPerson().getName()+":"+a.getPerson().getId());
		}
		
		transaction.commit();
		session.close();
	}
}
