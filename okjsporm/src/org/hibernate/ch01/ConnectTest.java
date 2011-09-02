/*-----------------------------------------------------------------
-- package 작성.
-----------------------------------------------------------------*/
package org.hibernate.ch01 ;

/*-----------------------------------------------------------------
-- java  import 작성
-----------------------------------------------------------------*/
import java.util.Date;
import java.util.List;

/*-----------------------------------------------------------------
-- junit  import 작성
-----------------------------------------------------------------*/
import junit.framework.TestCase;

/*-----------------------------------------------------------------
-- hibernate  import 작성
-----------------------------------------------------------------*/
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.util.HibernateUtil;

/**
 * Illustrates use of Hibernate native APIs.
 *
 * @author Steve Ebersole
 */
public class ConnectTest extends TestCase {
	private SessionFactory sessionFactory;

	
	@Override
	protected void setUp() throws Exception {
		
		System.out.println("  1-1)  start Junit setUp process") ; 
		
        sessionFactory = HibernateUtil.getSessionFactory() ; 

        System.out.println("  1-2)  end Junit setUp process") ; 
	}

	
	@Override
	protected void tearDown() throws Exception {

		System.out.println("  99-1)  start Junit tearDown process") ; 
		
		HibernateUtil.closeSession() ; 
		
		System.out.println("  99-2)  end Junit tearDown process") ; 
	}

	
	public void testBasicUsage() {
		
		System.out.println("  2-1)  start Junit testBasicUsage process") ; 
		
		Session session = HibernateUtil.getSession() ; // Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save( new Event( "Our very first event!", new Date() ) );
		session.save( new Event( "A follow up event"    , new Date() ) );
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = HibernateUtil.getSession() ; // sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Event" ).list();
		for ( Event event : (List<Event>) result ) {
			System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
		}
        session.getTransaction().commit();
        session.close();
		
		System.out.println("  2-2)  end Junit testBasicUsage process") ; 
		
	}
}
