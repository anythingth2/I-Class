package Model;

import Main.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Model {
    // Begin generally ORM methods

    public static void save(Model obj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveOrUpdate(Model obj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(Model obj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
