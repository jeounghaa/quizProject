<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/11
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>퀴즈리스트</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script>
        function goPlay(gId) {
            location.href = "/playB/play.do?serial=1&gId=" + gId;
        }

    </script>
    <style>
        td {
            margin: 10px;
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>번호</td>
            <td>게임명</td>
            <td>게임소개</td>
            <td>하러가기</td>
        </tr>
    <c:forEach items="${result}" var="gameVO" varStatus="no">
        <tr>
            <td>${no.count}</td>
            <td>${gameVO.getTitle()}</td>
            <td>${gameVO.getIntro()}</td>
            <td><button type="button" onclick="goPlay(${gameVO.getGId()})">게임 플레이!</button></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
