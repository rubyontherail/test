package org.hibernate.util ;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            initSessionFactory();
        }
        return sessionFactory;
    }
    
    private static synchronized void initSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
     
    public static Session getSession() {
        return getSessionFactory().openSession();
    }
    

    public static void closeSession() throws HibernateException {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}  
    }    

}
