package Model;

import Main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Model {
    public static Session session;
    public static Transaction transaction;
    // Open session
    public static void createSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }


    // Begin generally ORM methods
    public void save(){
        try {
//            Session session555 = HibernateUtil.getSessionFactory().getCurrentSession();
//            Transaction tx = session555.beginTransaction();
            session.save(this);
            if (!transaction.wasCommitted())
                transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        try {
//            Session session555 = HibernateUtil.getSessionFactory().getCurrentSession();
//            Transaction tx = session555.beginTransaction();
            session.update(this);
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void save(Model obj){
        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
            session.save(obj);
//            transaction.commit();
            if (!transaction.wasCommitted())
                transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveOrUpdate(Model obj){
        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(Model obj){
        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
