<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/05/15
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session = request.getSession();
    String id = (String) session.getAttribute("id");
%>
<html>
<head>
    <title>메인화면</title>
    <script>
        function goLogin() {
            location.href = "/user/login.do";
        }

        function goGameB() {
            location.href = "/gameB/game.do";
        }
        function doPlayB() {
            location.href = "/playB/playList.do";
        }

        function goMyPlay() {
            location.href = "/user/myPlay.do";
        }

        function gojoin() {
            location.href = "/user/join.do";
        }

        function goMyPage() {
            location.href = "/user/myPage.do";
        }

        function goLogout() {
            $.ajax({
                url: "/user/logout.ajax",
                type: "POST",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function () {
                    alert("로그아웃 되었습니다")
                },
                error: function (data) {
                    alert("로그아웃 실패");
                }
            });
        }

        function goGameA() {
            location.href = "/gameAType/gameACreate.do";
        }

        function goPlayGameA() {
            location.href = "/gameAType/gameAResult.do";
        }

    </script>
    <script src="/js/jquery-3.6.0.js"></script>
</head>
<body>
    <h1>메인화면입니다!</h1>
    <p>현재 로그인 유저 정보:
        <c:if test="${not empty id}">${id}</c:if>
        <c:if test="${empty id}">없음</c:if>
    </p>

    <c:if test="${empty id}">
        <button type="button" onclick="goLogin()">로그인</button>
        <button type="button" onclick="gojoin()">회원가입</button>
    </c:if>
    <c:if test="${not empty id}">
        <button type="button" onclick="goMyPage()">마이페이지</button>
        <button type="button" onclick="goLogout()">로그아웃</button>
    </c:if>
    <br>
<%--    <button type="button" onclick="goGameB()">게임하러 가기</button>--%>
    <br>
    <button type="button" onclick="goGameA()">게임A생성하러 가기</button>
    <br><br>
    <button type="button" onclick="goPlayGameA()">게임A하러 가기</button>
    <br><br>
    <button type="button" onclick="goGameB()">게임 만들러 가기</button>
    <br><br>
    <button type="button" onclick="doPlayB()">게임 플레이하러 가기</button>
</body>
</html>
