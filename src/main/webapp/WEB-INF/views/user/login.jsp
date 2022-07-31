<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/05/22
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <script>
        function goLogin() {
            $.ajax({
                url: "/user/selectUser.ajax",
                type: "POST",
                data: $("#loginForm").serialize(),
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    alert(data.msg);
                    location.href = "/user/main.do";
                },
                error: function (data) {
                    alert(data.msg);
                }
            })
        }

    </script>
    <script src="/js/jquery-3.6.0.js"></script>
</head>
<body>
<form id="loginForm">
    <label>아이디: </label>
    <input type="text" id="id" name="id">

    <label>비밀번호: </label>
    <input type="password" id="pw" name="pw">

    <button type="button" onclick="goLogin()">로그인</button>
</form>
</body>
</html>