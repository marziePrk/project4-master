<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">
    <title>ثبت مشتری حقوقی</title>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <h1 style="color: saddlebrown">لطفا اطلاعات مشتری را وارد نمایید:</h1>
    <br>
    <div class="tableBox">
        <form action="/CreateRealCustomerServlet" method="post">
            <table >
                <tr>
                    <td>نام شرکت :</td>
                    <td><input name="companyName" type="text"></td>
                </tr>
                <tr>
                    <td>تاریخ ثبت :</td>
                    <td><input name="registerDate" type="text"></td>
                </tr>
                <tr>
                    <td>کد اقتصادی :</td>
                    <td><input name="economicId" type="text"></td>
                </tr>

            </table>
            <input type="submit" class="button" value="ثبت اطلاعات ">

        </form>
    </div>




</div>
</body>
</html>
