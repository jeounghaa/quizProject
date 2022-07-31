<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/06/10
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session = request.getSession();
    String id = (String) session.getAttribute("id");
%>
<html>
<head>
    <title>선택한 게임 플레이</title>
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">

        function playGame() {

            $.ajax({
                url: "/playAType/playGame.ajax",
                type: "POST",
                data: $("#playA").serialize(),
                dataType: "text",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function () {
                    console.log("success");
                    window.location.href = "../playAType/playGameAResult.do";
                },
                error: function (request, error) {
                    console.log("message:"+request.responseText+"\n error: "+error);
                    console.log("fail");
                }
            })
        }
    </script>
</head>
<body>
<h2>${vo.title}</h2>
${vo.intro}<br/><br/><br/>

<form id="playA" action="playGame.do">
    <input type="text" name="gId" value="${gId}" hidden>
    <input type="text" name="uId" value="1" hidden>
    1) ${item_vo0.subTitle}<br/>
    <label><input type="radio" name="answer1" checked value="${item_vo0.content}/${item_vo0.giId}"}>${item_vo0.content}</label><br/>
    <label><input type="radio" name="answer1" value="${item_vo1.content}/${item_vo1.giId}">${item_vo1.content}</label>
    <br/><br/>

    2) ${item_vo2.subTitle}<br/>
    <label><input type="radio" name="answer2" checked value="${item_vo2.content}/${item_vo2.giId}">${item_vo2.content}</label><br/>
    <label><input type="radio" name="answer2" value="${item_vo3.content}/${item_vo3.giId}">${item_vo3.content}</label>
    <br/><br/>

    3) ${item_vo4.subTitle}<br/>
    <label><input type="radio" name="answer3" checked value="${item_vo4.content}/${item_vo4.giId}">${item_vo4.content}</label><br/>
    <label><input type="radio" name="answer3" value="${item_vo5.content}/${item_vo5.giId}">${item_vo5.content}</label
    <br/><br/><br/><br/>

    <input type="button" value="결과보기" onclick="playGame()">
</form>

</body>
</html>
