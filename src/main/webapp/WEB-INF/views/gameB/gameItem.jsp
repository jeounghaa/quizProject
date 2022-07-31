<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/04
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String gId = null;
  if (request.getAttribute("gId") != null) {
    gId = (String) request.getAttribute("gId");
  }
%>
<html>
<head>
    <title>게임아이템</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script>
        function insertGameItem() {
            $.ajax({
              url: "/gameB/insertGameItem.ajax",
              type: "POST",
              data: $("#gameItemForm").serialize(),
              dataType: "json",
              contentType: "application/x-www-form-urlencoded;charset=UTF-8",
              success: function (data) {
                let serial = $("#serial").val();

                if (serial == 3) {
                    alert("게임 생성이 끝났습니다. 메인화면으로 돌아갑니다.");
                    goMain();
                }
                else {
                    $("#serial").val(++serial);
                    clear();
                }
              },
              error: function (data) {
                alert(data.msg);
              }
            });
        }

        function clear() {
            $("#subTitle").val("");
            $("#content1").val("");
            $("#content2").val("");
            $("#score1").val("");
            $("#score2").val("");
            $("#answer1").val("");
            $("#answer2").val("");
            $("input:checkbox[id='answer1']").prop("checked", false);
            $("input:checkbox[id='answer2']").prop("checked", false);
        }

        function goMain() {
            location.href = "/user/main.do";
        }
    </script>

</head>
<body>

<form name="gameItemForm" id="gameItemForm">
    <input type="hidden" id="serial" name="serial" value="1">
    <input type="hidden" id="gId" name="gId" value="${gId}">

    <label>질문</label>
    <input type="text" name="subTitle" id="subTitle"><br>

    <label>첫번째 선택지</label>
    <input type="text" id="content1" name="content1">
    <input type="text" id="score1" name="score1" placeholder="점수">
    <input type="checkbox" id="answer1" name="answer1">정답여부<br>

    <label>두번째 선택지</label>
    <input type="text" id="content2" name="content2">
    <input type="text" id="score2" name="score2" placeholder="점수">
    <input type="checkbox" id="answer2" name="answer2">정답여부<br>

    <button type="button" onclick="insertGameItem()">문제 완성</button>

  </form>
</body>
</html>
