package dataAccessLayer.DAO;

import dataAccessLayer.RealCustomer;
import exception.HibernateExceptions;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dotin school 6 on 8/20/2016.
 */
public class RealCustomerDAO {

    //create real customer----------------------------------------------------------------------------------------------
    public static void createRealCustomer(RealCustomer realCustomer) throws HibernateExceptions {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(realCustomer);
            transaction.commit();
            session.close();
            Logger.getLogger(RealCustomer.class).info("real customer created.");
        } catch (HibernateException ex) {
            Logger.getLogger(RealCustomer.class).info("real customer dose not created.");
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            throw new HibernateExceptions("create real customer exception.......");
        }

    }

    //deleteRealCustomer------------------------------------------------------------------------------------------------
    public static void deleteRealCustomer(long id) throws HibernateExceptions {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            RealCustomer realCustomer = session.get(RealCustomer.class, id);
            session.remove(realCustomer);
            transaction.commit();
            session.close();
            Logger.getLogger(RealCustomer.class).info("real customer deleted.");
        } catch (HibernateException ex) {
            Logger.getLogger(RealCustomer.class).info("real customer dose not deleted.");
            transaction.rollback();
            session.close();
            throw new HibernateExceptions("");
        }

    }

    //updateRealCustomer------------------------------------------------------------------------------------------------
    public static void updateRealCustomer(long id, String firstName, String lastName, String fatherName, String birthDate, String nationalId) throws HibernateExceptions {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            RealCustomer realCustomer = new RealCustomer(id ,firstName, lastName, fatherName, birthDate, nationalId);
            session.update(realCustomer);
            transaction.commit();
            session.close();
            Logger.getLogger(RealCustomer.class).info("real customer updated.");

        } catch (HibernateException ex) {
            Logger.getLogger(RealCustomer.class).info("real customer dose not deleted.");
            transaction.rollback();
            session.close();
            throw new HibernateExceptions("");
        }

    }

    //retrieveRealCustomerByCustomerNumber------------------------------------------------------------------------------
    public static List<RealCustomer> retrieveRealCustomerByCustomerNumber(String customerNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers = null;
        Query query;
        try {
            if (customerNumber.equals("")) {
                String hql = "from RealCustomer ";
                query = session.createQuery(hql);
                realCustomers = query.list();
            }
            if(!customerNumber.equals("")){
                String hql = "from RealCustomer realCustomer where customerNumber = :customerNumber";
                query = session.createQuery(hql);
                query.setParameter("customerNumber", Integer.parseInt(customerNumber));
                realCustomers = query.list();
            }
            transaction.commit();
            Logger.getLogger(RealCustomer.class).info("real customer retrieved.");

        }finally {
            session.close();
        }

        return realCustomers;
    }

    //retrieveRealCustomerByNationalId----------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomerByNationalId(String nationalId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers;
        try {
            String hql = "from RealCustomer realCustomer where nationalId = :nationalId";
            Query query = session.createQuery(hql);
            query.setParameter("nationalId" , nationalId);
            realCustomers = query.list();
            transaction.commit();
            Logger.getLogger(RealCustomer.class).info("real customer retrieved.");
        } finally {
            session.close();
        }
        return (ArrayList<RealCustomer>) realCustomers;
    }

    //retrieveRealCustomer----------------------------------------------------------------------------------------------
    public static ArrayList<RealCustomer> retrieveRealCustomer(String firstName, String lastName, String nationalCode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealCustomer> realCustomers = null;
        Query query = null;

        if (!firstName.equals("") && !lastName.equals("") &&! nationalCode.equals("") ) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and lastName = :lastName and nationalId = :nationalCode";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("nationalCode", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("") && !lastName.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and lastName = :lastName";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("") && !nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName and nationalId = :nationalId";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            query.setParameter("nationalId", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!lastName.equals("") && !nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where lastName = :lastName and nationalId = :nationalId";
            query = session.createQuery(hql);
            query.setParameter("lastName", lastName);
            query.setParameter("nationalId", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer where nationalId = :nationalCode";
            query = session.createQuery(hql);
            query.setParameter("nationalCode", nationalCode);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (firstName.equals("") && lastName.equals("") && nationalCode.equals("")) {
            String hql = "from RealCustomer realCustomer";
            query = session.createQuery(hql);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!firstName.equals("")) {
            String hql = "from RealCustomer realCustomer where firstName = :firstName ";
            query = session.createQuery(hql);
            query.setParameter("firstName", firstName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }else
        if (!lastName.equals("")) {
            String hql = "from RealCustomer realCustomer where lastName = :lastName ";
            query = session.createQuery(hql);
            query.setParameter("lastName", lastName);
            realCustomers = query.list();
            transaction.commit();
            session.close();
            return (ArrayList<RealCustomer>) realCustomers;
        }
        Logger.getLogger(RealCustomer.class).info("real customer retrieved.");
           /* realCustomers = query.list();
            transaction.commit();*/

        return null;
    }

    //generateCustomerNumber--------------------------------------------------------------------------------------------
    public static int generateCustomerNumber() {
        int customerNumber;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            long count = retrieveRealCustomerCount();
            if (count == 0) {
                return 1000;
            } else {
                String maxHql = "select max(realCustomer.customerNumber) from RealCustomer realCustomer";
                Query query = session.createQuery(maxHql);
                customerNumber = ((Integer) query.uniqueResult());
                transaction.commit();
                int newNumber = customerNumber + 1;
                return newNumber;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }

    //retrieveRealCustomerCount-----------------------------------------------------------------------------------------
    private static long retrieveRealCustomerCount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Long count;
        try {
            String hql = "Select count (*) from RealCustomer realCustomer";
            Query query = session.createQuery(hql);
            count = (Long) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(RealCustomer.class).info("real customer retrieved.");
        } finally {
            session.close();
        }
        return count;
    }

    public static RealCustomer retrieveRealCustomerById(long customerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        RealCustomer realCustomer ;
        try {
            String hql = "from RealCustomer realCustomer where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id" , customerId);
            realCustomer = (RealCustomer) query.uniqueResult();
            transaction.commit();
            Logger.getLogger(RealCustomer.class).info("real customer retrieved.");
        } finally {
            session.close();
        }
        return realCustomer;

    }
}