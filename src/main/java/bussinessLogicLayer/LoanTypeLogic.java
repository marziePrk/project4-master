package bussinessLogicLayer;

import bussinessLogicLayer.exception.EmptyFieldException;
import bussinessLogicLayer.exception.HibernateExceptions;
import dataAccessLayer.DAO.LoanTypeDAO;
import dataAccessLayer.LoanType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin school 6 on 8/22/2016.
 */
public class LoanTypeLogic {

    public static List<LoanType> retrieveLoanTypes() throws HibernateExceptions {
        List<LoanType> loanTypes = LoanTypeDAO.retrieveLoanTypes();
        return loanTypes;
    }

    public static LoanType validate(String loanTypeName, String interestRate) throws EmptyFieldException {
        if (loanTypeName.equals("") || interestRate.equals("")) {
            throw new EmptyFieldException("");
        } else {
            LoanType loanType = new LoanType(loanTypeName, interestRate);
            return loanType;
        }
    }
}

