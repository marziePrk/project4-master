package dataAccessLayer.DAO;

import bussinessLogicLayer.exception.HibernateExceptions;
import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class GrantConditionDAO {
    public static void create(LoanType loanType, ArrayList<GrantCondition> grantConditionList) throws HibernateExceptions {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            /*session.save(loanType);*/
            LoanTypeDAO.create(loanType);
            for (GrantCondition grantCondition: grantConditionList){
                grantCondition.setLOAN_TYPE_ID(loanType.getId());
                session.save(grantCondition);
                Logger.getLogger(GrantCondition.class).info("Grant Conditions created.");
            }
            transaction.commit();
        } catch (HibernateException e) {
            Logger.getLogger(GrantCondition.class).info("Grant Conditions dose not created.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        }finally {
            session.close();
        }

    }

    public static GrantCondition retrieveByName(String name) throws HibernateExceptions {
        Session session = null;
        GrantCondition grantCondition = new GrantCondition();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from GrantCondition grantCondition where name = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            grantCondition = (GrantCondition) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(GrantCondition.class).info("Grant Conditions retrieved.");
        }catch (HibernateException e){
            Logger.getLogger(GrantCondition.class).info("Grant Conditions dose not retrieved.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        } finally {
            session.close();
        }
        return grantCondition;

    }

    public static List<GrantCondition> retrieveByLoanId(int loanTypeId) throws HibernateExceptions {
        List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "from GrantCondition grantCondition where LOAN_TYPE_ID = :loanTypeId";
            Query query = session.createQuery(hql);
            query.setParameter("loanTypeId", loanTypeId);
            grantConditions = query.list();
            transaction.commit();
            Logger.getLogger(GrantCondition.class).info("Grant Conditions  retrieved.");
        }catch (HibernateException e){
            Logger.getLogger(GrantCondition.class).info("Grant Conditions dose not retrieved.");
            e.printStackTrace();
            throw new HibernateExceptions("خطای سیستمی...");
        } finally {
            session.close();
        }
        return grantConditions;

    }
}
