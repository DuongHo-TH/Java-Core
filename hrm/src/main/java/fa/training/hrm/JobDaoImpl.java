package fa.training.hrm;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JobDaoImpl implements JobDao {
    
    @Override
    public boolean save(Jobs job) throws Exception {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.saveOrUpdate(job);
            
            transaction.commit();
            
            return false;
            
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}