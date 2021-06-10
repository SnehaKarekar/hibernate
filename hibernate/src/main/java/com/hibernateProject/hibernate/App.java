package com.hibernateProject.hibernate;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf=conf.buildSessionFactory(registry);
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        
        Student student=new Student();
        student.setName("sneha");
        Laptop laptop=new Laptop();
        laptop.setLaptopId(1);
        laptop.setLaptopName("Hp");
        laptop.setLaptopPrice(500.10);
        FileInputStream fis=new FileInputStream("src/main/java/laptop.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        laptop.setLaptopImage(data);
        session.save(student);
        session.save(laptop);
        transaction.commit();
        session.close();
    }
}
