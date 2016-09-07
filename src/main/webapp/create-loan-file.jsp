<%@ page import="dataAccessLayer.LoanType" %>
<%@ page import="dataAccessLayer.RealCustomer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String customerExistsString = (String) request.getAttribute("customerExists");%>
<% boolean customerExist = customerExistsString == null ? false : true;%>
<% RealCustomer firstCustomer = new RealCustomer(0, "", "", "", "", "");%>
<% RealCustomer realCustomer = customerExist == false ? firstCustomer : (RealCustomer) request.getAttribute("realCustomer"); %>
<%--<% RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer");%>
<% String firstName = realCustomer == null ? "" : realCustomer.getFirstName();%>
<% String lastName = realCustomer == null ? "" : realCustomer.getLastName();%>
<% int customerId = realCustomer == null ? 0 : (int) realCustomer.getId();%>
<% int customerNumber = realCustomer == null ? new Integer("") : realCustomer.getCustomerNumber();%>--%>

<!DOCTYPE html>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <title>تعریف پرونده تسهیلاتی</title>
</head>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <div class="tableBox">
        <form action="/CreateLoanFileServlet">
            <input name="action" value="retrieveCustomer" type="text" hidden>
            <table>
                <tr>
                    <td>شماره مشتری :</td>
                    <td>
                        <input name="customerNumber" id="customerNumber" type="text" placeholder="  شماره مشتری.."
                               value="<%=realCustomer.getCustomerNumber() == 0 ? "" : realCustomer.getCustomerNumber() %>">
                    </td>
                    <td>
                        <input type="submit" class="button" value="بازیابی">
                    </td>
                </tr>
                <tr>
                    <td>نام :</td>
                    <td>
                        <input name="firstName" id="firstName" type="text"
                               value="<%=realCustomer.getFirstName()%>" readonly>
                    </td>
                </tr>
                <tr>
                    <td>نام خانوادگی :</td>
                    <td>
                        <input name="lastName" id="lastName" type="text"
                               value="<%=realCustomer.getLastName()%>" readonly>
                    </td>
                </tr>
                </table>
        </form>
        <form>
            <table>
                <input name="customerId" value="<%=realCustomer.getId()%>" type="text" hidden>
                <input name="action" value="createLoanFile" type="text" hidden>
                <tr>
                    <td>مدت قرارداد :</td>
                    <td><input name="duration" id="duration" type="text" placeholder="  مدت قرارداد.."></td>
                </tr>
                <tr>
                    <td>مبلغ قرارداد :</td>
                    <td><input name="amount" id="amount" type="text" placeholder="  مبلغ قرارداد.."></td>
                </tr>
                <% ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) request.getAttribute("loanTypes"); %>
                <tr>
                    <td>نوع تسهیلات :</td>
                    <td><select name="chosenLoanType">
                        <% for (LoanType loanType : loanTypes) {%>
                        <option value="<%=loanType.getId()%>"><%=loanType.getName()%>
                        </option>
                        <%}%>
                    </select></td>
                </tr>
            </table>
            <input type="submit" class="button" value="ثبت">
        </form>
        <br>
        <br>
        <br>

        <%-- <% boolean customerExists = Boolean.parseBoolean(String.valueOf(request.getAttribute("customerExists")));%>
         <% if (customerExists) {%>
         <% RealCustomer realCustomer = (RealCustomer) request.getAttribute("realCustomer"); %>
         <form action="/CreateLoanFileServlet">
             <input type="text" name="action" value="createLoanFile" hidden>
             <input name="action" value="createLoanFile" type="text" hidden>
             <input name="customerId" value="<%=realCustomer.getId()%>" type="text" hidden>
             <table>
                 <tr>
                     <td>شماره مشتری :</td>
                     <td>
                         <input name="customerNumber" id="customerNumber" type="text"
                                value="<%=realCustomer.getCustomerNumber()%>" readonly>
                     </td>
                     <td>
                         <input type="button" onclick="" class="button" value="بازیابی">
                     </td>
                 </tr>
                 <tr>
                     <td>نام :</td>
                     <td><input name="firstName" id="firstName" type="text"
                                value="<%=realCustomer.getFirstName()%>" readonly></td>
                 </tr>
                 <tr>
                     <td>نام خانوادگی :</td>
                     <td><input name="lastName" id="lastName" type="text"
                                value="<%=realCustomer.getLastName()%>" readonly></td>
                 </tr>
                 <tr>
                     <td>مدت قرارداد :</td>
                     <td><input name="duration" id="duration" type="text" placeholder="مدت قرارداد.."></td>
                 </tr>
                 <tr>
                     <td>مبلغ قرارداد :</td>
                     <td><input name="amount" id="amount" type="text" placeholder="مبلغ قرارداد.."></td>
                 </tr>
                 <% ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) request.getAttribute("loanTypes"); %>
                 <tr>
                     <td>نوع تسهیلات :</td>
                     <td><select name="chosenLoanType">
                         <% for (LoanType loanType : loanTypes) {%>
                         <option value="<%=loanType.getId()%>"><%=loanType.getName()%>
                         </option>
                         <%}%>
                     </select></td>
                 </tr>
             </table>
             <input type="submit" class="button" value="ثبت">
         </form>
         <%}%>
         <br>
         <br>
         <br>


         <% boolean loanTypeExist = Boolean.parseBoolean(String.valueOf(request.getAttribute("loanTypeExist"))); %>
         <% if (loanTypeExist) {%>
         <form action="/CreateLoanFileServlet">
             <input type="text" name="action" value="retrieveCustomer" hidden>
             <table>
                 <tr>
                     <td>شماره مشتری :</td>
                     <td>
                         <input name="customerNumber" type="text" placeholder="شماره مشتری.."
                            oninvalid="alert('فیلد شماره مشتری را جهت بازیابی پرکنید.');" required>
                     </td>
                     <td><input type="submit" class="button" value="بازیابی"></td>
                 </tr>
                 <tr>
                     <td>نام :</td>
                     <td><input name="firstName" type="text" value="" readonly>
                     </td>
                 </tr>
                 <tr>
                     <td>نام خانوادگی :</td>
                     <td><input name="lastName" type="text"
                                value="" readonly></td>
                 </tr>
                 <tr>
                     <td>مدت قرارداد :</td>
                     <td><input name="duration" type="text" placeholder="مدت قرارداد.."></td>
                 </tr>
                 <tr>
                     <td>مبلغ قرارداد :</td>
                     <td><input name="amount" type="text" placeholder="مبلغ قرارداد.."></td>
                 </tr>
                 <% ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) request.getAttribute("loanTypes"); %>
                 <tr>
                     <td>نوع تسهیلات :</td>
                     <td><select name="chosenLoanType">
                         <% for (LoanType loanType : loanTypes) {%>
                         <option value="<%=loanType.getId()%>"><%=loanType.getName()%>
                         </option>
                         <%}%>
                     </select></td>
                 </tr>
             </table>
             <input type="button" onclick="" class="button" value="ثبت">
         </form>
         <br>
         <%}%>--%>
    </div>
</div>

</body>
</html>
