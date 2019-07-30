

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录注册界面</title>
</head>
<body>

<table border="1" align="center" width="65%">
    <caption>Login</caption>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username" id="username"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="password" name="password" id="password"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="checkbox" name="remember" value="on" />记住用户
            <input type="checkbox" name="autologin" value="on" />自动登陆
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" name="登录" onclick="check();" value="登录">
        </td>
        <td>
            <input type="button" name="注册" value="注册" onclick="registerjsp();" />
        </td>
    </tr>

</table>

<script src="jq\jquery-1.12.4.js"></script>
<script>
    function registerjsp(){
        window.location.href="register.jsp";
    }

    function check() {

        var username = $("#username").val();
        var password = $("#password").val();

        $.post("LoginServlet",
            {"username" : username,"password" : password},
            function(result) {
                if (result=="1") {
                    alert("账户或密码错误");
                    window.location.href='login.jsp';
                }else{
                    alert("登录成功");
                }

            }

        )
        }





</script>


</body>
</html>