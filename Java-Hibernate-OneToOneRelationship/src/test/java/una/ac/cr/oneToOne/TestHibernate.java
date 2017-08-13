/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.oneToOne;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import una.ac.cr.oneToOne.HibernateUtil;
import una.ac.cr.oneToOne.model.Passport_detail;
import una.ac.cr.oneToOne.model.Person;
/**
 *
 * @author mguzmana
 */
public class TestHibernate {

    public TestHibernate() {
    }

    @Before
    public void setUp() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSave() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // begin a transaction 
        session.beginTransaction();

        Passport_detail passport = new Passport_detail();
        passport.setPassportno("ABC123");

        session.save(passport);
        System.out.println("Passport saved, id:  " + passport.getId());
        Person person = new Person();
        person.setName("Alejandro Sánchez");
        person.setPassport_detail_id(passport);
        session.save(person);
        System.out.println("Person saved, id:  " + person.getId());

        // commit transaction
        session.getTransaction().commit();

        session.close();
        HibernateUtil.shutdown();

    }
    @Test
     public void testList() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        // begin a transaction 

        Query query = session.createQuery("from Person ");
	        List<?> list = query.list();
	        List<Person> persons = (List<Person>)list;
                for(int i = 0; i < persons.size();i++){
                    System.out.println("Nombre: " + persons.get(i).getName());
                    System.out.println("Pasaporte: " + persons.get(i).getPassport_detail_id().getPassportno());
                }
        

     }
}
