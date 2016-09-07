package dataAccessLayer.DAO;

import bussinessLogicLayer.exception.HibernateExceptions;
import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class LoanTypeDAO {
    public static ArrayList<LoanType> retrieveLoanTypes() throws HibernateExceptions {
        Session session = null;
        ArrayList<LoanType> loanTypes;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from LoanType loanType";
            Query query = session.createQuery(hql);
            loanTypes = (ArrayList<LoanType>) query.list();
            transaction.commit();
            Logger.getLogger(LoanTypeDAO.class).info("loan type retrieved.");
        } catch (HibernateException e) {
            Logger.getLogger(GrantCondition.class).info("Loan Type dose not created.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        } finally {
            session.close();
        }
        return loanTypes;
    }

    public static LoanType retrieveLoanTypesById(int loanTypeId) throws HibernateExceptions {
        LoanType loanTypes;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from LoanType loanType where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", loanTypeId);
            loanTypes = (LoanType) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(LoanTypeDAO.class).info("loan type retrieved.");
        } catch (HibernateException e) {
            Logger.getLogger(GrantCondition.class).info("Loan Type dose not created.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        } finally {
            session.close();
        }
        return loanTypes;
    }

    public static void create(LoanType loanType) throws HibernateExceptions {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(loanType);
            transaction.commit();
            Logger.getLogger(GrantCondition.class).info("Loan Type created.");
        } catch (HibernateException e) {
            Logger.getLogger(GrantCondition.class).info("Loan Type dose not created.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        }finally {
            session.close();
        }
    }
}



    /*public static List<LoanType> retrieveLoanTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from RealCustomer ";
        Query query = session.createQuery(hql);
        List<LoanType> loanTypes = query.list();
        transaction.commit();
        session.close();
        return loanTypes;
    }*/
