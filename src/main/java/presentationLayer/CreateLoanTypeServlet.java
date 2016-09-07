package presentationLayer;

import bussinessLogicLayer.LoanTypeLogic;
import bussinessLogicLayer.exception.EmptyFieldException;
import dataAccessLayer.LoanType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dotin school 6 on 8/23/2016.
 */
public class CreateLoanTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String loanTypeName = request.getParameter("loanTypeName");
        String interestRate = request.getParameter("interestRate");
        try {
            LoanType loanType = LoanTypeLogic.validate(loanTypeName.trim(), interestRate.trim());
            request.setAttribute("loanTypeName", loanTypeName);
            request.setAttribute("interestRate", interestRate);
            request.setAttribute("loanType", loanType);
            //getServletContext().getRequestDispatcher("/create-grant-condition.jsp").forward(request, response);

        } catch (EmptyFieldException e) {
            e.printStackTrace();
            request.setAttribute("title", "خطا");
            request.setAttribute("header", "خطا سیستمی");
            //getServletContext().getRequestDispatcher("/result-page.jsp").forward(request, response);
        } finally {
            getServletContext().getRequestDispatcher("/create-grant-condition.jsp").forward(request, response);
        }
    }

}