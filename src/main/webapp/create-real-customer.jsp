<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <link href="style/Style.css" rel="stylesheet">

    <script type="text/javascript">
        function validate() {
            var code = document.forms["myForm"]["nationalCode"].value;
            if (code.length == 10) {
                var rightMostNumber = parseInt(code.charAt(9));
                var sum = parseInt(code.charAt(0)) * 10 +
                        parseInt(code.charAt(1)) * 9 +
                        parseInt(code.charAt(2)) * 8 +
                        parseInt(code.charAt(3)) * 7 +
                        parseInt(code.charAt(4)) * 6 +
                        parseInt(code.charAt(5)) * 5 +
                        parseInt(code.charAt(6)) * 4 +
                        parseInt(code.charAt(7)) * 3 +
                        parseInt(code.charAt(8)) * 2;

                var result = sum % 11 ;
                if (result == rightMostNumber || result == 11 - rightMostNumber){
                    return true
                }else {
                    alert("کد ملی صحیح نمی باشد.");
                    return false;
                }
            } else {
                alert("کد ملی باید ده رقمی باشد. ");
                return false;
            }
        }
    </script>
    <title>ثبت مشتری حقیقی</title>
</head>
<body>
<div class="pageHeader">
</div>
<div><h6>نسخه آزمایشی</h6></div>
<div class="content">
    <h1 style="color: saddlebrown">لطفا اطلاعات مشتری را وارد نمایید:</h1>
    <br>
    <div class="tableBox">
        <form name="myForm" action="/CreateRealCustomerServlet" onsubmit="return validate()" method="post">
            <table>
                <tr>
                    <td>نام :</td>
                    <td><input name="firstName" type="text" placeholder="  نام.."></td>
                </tr>
                <tr>
                    <td>نام خانوادگی :</td>
                    <td><input name="lastName" type="text" placeholder="  نام خانوادگی.."></td>
                </tr>
                <tr>
                    <td>نام پدر :</td>
                    <td><input name="fatherName" type="text" placeholder="  نام پدر.."></td>
                </tr>
                <tr>
                    <td>تاریخ تولد :</td>
                    <td><input name="birthDate" type="text" placeholder="  تاریخ تولد.."></td>
                </tr>
                <tr>
                    <td>شماره ملی :</td>
                    <td><input name="nationalCode" type="text" id="nationalCode" placeholder="  شماره ملی.."></td>
                </tr>

            </table>
            <input type="submit" class="button" value="ثبت اطلاعات">

        </form>
    </div>
</div>
</body>
</html>
