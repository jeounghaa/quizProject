<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/04
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int gId;
  if (request.getAttribute("gId") != null) {
    gId = (int) request.getAttribute("gId");
  }

%>
<html>
<head>
    <title>고르기 게임 만들기</title>
  <script>
    function insertGame() {
      $.ajax({
        url: "/gameB/insertGame.ajax",
        type: "POST",
        data: $("#gameForm").serialize(),
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        success: function (data) {
          //console.log(JSON.stringify(data));
          // console.log(JSON.stringify(data.gameVO.gid));
          //alert(data.msg + " / " + data.gId);
          goGameItem(data.gId);
        },
        error: function (data) {
          alert(data.msg);
        }
      });
    }

    function goGameItem(gId) {
      location.href = "/gameB/gameItem.do?gId=" + gId;
    }
  </script>
  <script src="/js/jquery-3.6.0.js"></script>
</head>
<body>
  <form id="gameForm">
    <input type="hidden" id="type" name="type" value="gameB">

    <label>게임 제목</label>
    <input type="text" id="title" name="title"><br>

    <label>게임 소개</label>
    <input type="text" id="intro" name="intro"><br>

<%--    <label>섬네일</label>--%>
<%--    <input type="file" id="thumbnail" name="thumbnail"><br>--%>

    <button type="button" onclick="insertGame()">새 게임 생성</button><br><br>
  </form>

</body>
</html>
