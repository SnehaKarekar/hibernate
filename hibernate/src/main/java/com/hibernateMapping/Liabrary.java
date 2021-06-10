package com.hibernateMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class Liabrary {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(People.class).addAnnotatedClass(Books.class);
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf=config.buildSessionFactory(sr);
		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		
		People people=new People();
		people.setName("a");
		people.setEmail("a123@gmail.com");
		
		Books books=new Books();
		books.setName("abc");
		books.setAuthor("sneha");
		
		people.setB(books);
		books.setP(people);
		
		session.save(books);
		session.save(people);
		
		transaction.commit();
		
		//fetch data
		Books b=(Books) session.get(Books.class, 1);
		String bName=b.getName();
		String bAuthor=b.getAuthor();
		String email=b.getP().getEmail();
		System.out.println(bName+" : "+bAuthor+" : "+email);

		
		session.close();
	}
}
