<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/12
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <script>
        function goJoin() {
            $.ajax({
                url: "/user/insertUser.ajax",
                type: "POST",
                data: $("#userForm").serialize(),
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    alert(data.msg);
                    location.href = "/user/login.do";
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
    <form id="userForm">
        <table>
            <tr>
                <td><label>아이디</label></td>
                <td><input type="text" id="id" name="id"><br></td>
            </tr>
            <tr>
                <td><label>비밀번호</label></td>
                <td><input type="password" id="pw" name="pw"><br></td>
            </tr>
            <tr>
                <td><label>이름</label></td>
                <td><input type="text" id="name" name="name"><br></td>
            </tr>
            <tr>
                <td><label>이메일</label></td>
                <td><input type="text" id="email" name="email"><br></td>
            </tr>

        </table>

        <button type="button" onclick="goJoin()">회원가입</button>
    </form>
</body>
</html>
