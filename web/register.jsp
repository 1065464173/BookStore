
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<table border="1" align="center" width="65%">
    <caption>注册</caption>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username" id="registerusername"/></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="password1" id="registerpassword"/></td>
    </tr>
    <tr>
        <td>确认密码</td>
        <td><input type="text" name="password1" id="comfirmpassword"/></td></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="text" name="email" id="registeremail"/></td>
    </tr>
    <tr>
        <td>验证码</td>
        <td><input type="text" name="verifyCode" id="registerVerifyCode"/>
            <img id="verifyImg" src="RegisterServlet.verifyCodeimage" alt="单击" />
        </td>

    </tr>
    <tr>
        <td><input type ="button" name="提交"  value="提交" onclick="register();"></td>
    </tr>


</table>
<script src="js/jquery-1.7.2/jquery.js"></script>
<script>
    function register(){
    var username =$("#registerUsername");
    var password1 = $("#registerPassword");
    var password2 = $("#comfirmPassword");
    var email = $("#registerEmail");
    var verifyCode = $("#registerVerifyCode");
    $.post("RegisterServlet",
        {"username" : username,"password1" : password1,"password2":password2,
            "email":email,"VerifyCode":verifyCode},
        function(result) {

        }
    )

    }

 $("#verifyImg").click(function () {
  $(this).attr('src','RegisterServlet.verifyCodeimage');
     })

</script>
</body>
</html>
