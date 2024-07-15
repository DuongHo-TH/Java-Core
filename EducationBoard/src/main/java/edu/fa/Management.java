package edu.fa;
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import edu.fa.model.Course;



public class Management {
	public static void main(String[] args) {
		Course course = new Course(2, "Hibernata");
		 SessionFactory sessionFactory= SessionFactoryProvider.provideSessionFactory(); 
	        Session session=sessionFactory.openSession(); 
	        Transaction t=session.beginTransaction(); 
		 session.save(course);
		 t.commit();
		 sessionFactory.close();
	}

}
	