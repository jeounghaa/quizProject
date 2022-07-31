<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/12
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>마이페이지</title>
    <style>
        div {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<div>
    <p>내 정보</p>
    <table>
        <tr>
            <td>이름</td>
            <td>아이디</td>
            <td>이메일</td>
            <td>회원가입일</td>
        </tr>
        <tr>
            <td>${resultUser.getName()}</td>
            <td>${resultUser.getId()}</td>
            <td>${resultUser.getEmail()}</td>
            <td>${resultUser.getFirstDt()}</td>
        </tr>
    </table>
</div>

<div>
    <p>내가 만든 게임</p>

    <c:if test="${not empty resultGame}">
        <table>
            <tr>
                <td>번호</td>
                <td>게임제목</td>
                <td>게임소개</td>
                <td>생성일</td>
            </tr>

            <c:forEach items="${resultGame}" var="gameVO">
                <tr>
                    <td>${gameVO.getGId()}</td>
                    <td>${gameVO.getTitle()}</td>
                    <td>${gameVO.getIntro()}</td>
                    <td>${gameVO.getFirstDt()}</td>
                </tr>
            </c:forEach>

        </table>
    </c:if>
    <c:if test="${empty resultGame}">
        만든 게임이 없습니다
    </c:if>

</div>

<%--<div>--%>
<%--    <p>참여한 게임</p>--%>
<%--</div>--%>

</body>
</html>
