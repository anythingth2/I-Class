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
            session.save(this);
            if (!transaction.wasCommitted())
                transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void persist(){
        try {
            session.persist(this);
            if (!transaction.wasCommitted())
                transaction.commit();
            session.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        try {
            session.update(this);
            if (!transaction.wasCommitted())
                transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveOrUpdate(){
        try {
            session.saveOrUpdate(this);
            if (!transaction.wasCommitted())
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

    public static void commit(){
        try {
//            if (!transaction.wasCommitted())
                transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return session;
    }
}
