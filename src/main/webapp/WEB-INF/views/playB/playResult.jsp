<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/12
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>플레이 결과</title>
    <script>
        function goMain() {
            location.href = "/user/main.do";
        }
    </script>
</head>
<body>
    <table>
        <tr>
            <td>맞은 문제 수</td>
            <td>틀린 문제 수</td>
            <td>총 점수</td>
        </tr>
        <tr>
            <td>${result.good}</td>
            <td>${result.bad}</td>
            <td>${result.total}</td>
        </tr>

    </table>

    <button type="button" onclick="goMain()">메인화면으로 돌아가기</button>
</body>
</html>
