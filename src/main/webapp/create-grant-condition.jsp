<%@ page import="dataAccessLayer.LoanType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LoanType loanType = (LoanType) request.getAttribute("loanType");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">

    <script type="text/javascript" src="create-table.js"></script>
    <title>تعریف شروط اعطا تسهیلات</title>
</head>
<body>
<div class="content">
    <h2> تسهیلات <%=loanType.getName()%> با نرخ سود <%=loanType.getInterestRate()%> درصد</h2>
    <h3 style="color: saddlebrown">لطفا شرایط اعطا را وارد نمایید:</h3>
    <br>
    <form>
        <table align="center">
            <tr>
                <td>نام شرط اعطا:</td>
                <td><input id="grantName" type="text" placeholder="نام.."></td>
            </tr>
            <tr>
                <td>حداقل مدت :</td>
                <td><input id="minDuration" type="text" placeholder="  حداقل مدت قرارداد.."></td>

            </tr>
            <tr>
                <td>حداکثر مدت :</td>
                <td><input id="maxDuration" type="text" placeholder="  حداکثر مدت قرارداد.."></td>
            </tr>
            <tr>
                <td>حداقل مبلغ :</td>
                <td><input id="minAmount" type="text" placeholder="  حداقل مبلغ قرارداد.."></td>

            </tr>
            <tr>
                <td>حداکثر مبلغ :</td>
                <td><input id="maxAmount" type="text" placeholder="  حداکثر مبلغ قرارداد.."></td>
            </tr>
        </table>
    </form>

    <button class="button" onclick="showTable()">نمایش</button>


    <form name="myForm" action="/CreateGrantConditionServlet" method="post">
        <input type="hidden" name="loanType" value="<%=request.getParameter("loanTypeName")%>">
        <input type="hidden" name="interestRate" value="<%=request.getParameter("interestRate")%>">
        <input type="hidden" name="rowNumber" id="rowNumber">
        <%--
                    <a href="create-loan-type.jsp" class=button>صفحه قبل</a>
        --%>
        <div class="searchTable">
            <table align="center" id="grantTableId">
            </table>
        </div>
        <input type="submit" class="button" value="ثبت اطلاعات">
    </form>

</div>

</body>
</html>