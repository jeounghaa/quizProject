<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/06/07
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        function addTest(){
            $.ajax({
                url: "/gameAType/addTest.ajax",
                type: "POST",
                // data: $("#gameA").serialize(),
                dataType: "text",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    console.log("success");
                },
                errors: function (data) {
                    console.log("errors!");
                }
            })
        }

        function addPlay(gId){
            console.log("gid: " + gId);
            const sendData = {"gId":gId}
            $.ajax({
                url: "/gameAType/addPlay.ajax",
                type: "POST",
                data: sendData,
                dataType: "text",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    console.log("success");
                },
                errors: function (data) {
                    console.log("errors!");
                }
            })
        }

    </script>

</head>
<body>
<h3>테스트 A TYPE</h3>
  <br/>

      <br/>
  <table border="1">
      <tr>
          <th>title</th>
          <th>intro</th>
          <th>gid</th>
      </tr>
      <c:forEach items="${vo}" var="vo">
          <tr>
              <td onclick="addPlay(${vo.GId})"> <a href="/playAType/playGame.do?gId=${vo.GId}">${vo.title}</a></td>
              <td>${vo.intro}</td>
              <td>${vo.GId}</td>
          </tr>
      </c:forEach>
  </table>
<%--  <input type="button" onclick="sel()" value="값 가져오기">--%>

<%--<input type="button" id="btn1" onclick="addTest()" value="가져오기">--%>
</body>
</html>
