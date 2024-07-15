package HibernateTest.hibernate;

import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
  
public class Create { 
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    { 
        SessionFactory sessionFactory=SessionFactoryProvider.provideSessionFactory(); 
        Session session=sessionFactory.openSession(); 
        Transaction t=session.beginTransaction(); 
          
        Student s =new Student(105,"Duong",12); 
        Student b =new Student(106,"Ho",14); 
        Student c =new Student(107,"Stepn",16); 
        session.save(s); 
        session.save(b); 
        session.save(c); 
        t.commit(); 
          
        sessionFactory.close(); 
    } 
} 