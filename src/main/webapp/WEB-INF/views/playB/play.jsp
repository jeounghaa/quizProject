<%--
  Created by IntelliJ IDEA.
  User: lsy
  Date: 2022/06/11
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("serial", 1);
%>
<html>
<head>
    <title>플레이</title>
    <script src="/js/jquery-3.6.0.js"></script>
    <script>
        function goPlay(gId) {
            location.href = "/playB/play.do?gId=" + gId;
        }
        
        function insertPlayItem() {
            $.ajax({
                url: "/playB/insertPlayItem.ajax",
                type: "POST",
                data: $("#playItemForm").serialize(),
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    let serial = $("#serial").val();

                    if (serial == 3) {
                        alert("플레이가 끝났습니다. 결과화면으로 돌아갑니다.");
                        goPlayResult(${pId});
                    }
                    else {
                        $("#serial").val(++serial);
                        location.href = "/playB/play.do?serial=" + $("#serial").val() + "&gId=" + ${gId} + "&pId=" + ${pId};
                    }
                },
                error: function (data) {
                    alert(data.msg);
                }
            });
        }

        function goPlayResult(pId) {
            location.href = "/playB/playResult.do?pId=" + pId;
        }
    </script>
    <style>

    </style>
</head>
<body>
    <p>${order}번째 문제</p>
    <input type="hidden" id="gId" name="gId" value="${gId}">

    <form id="playItemForm" name="playItemForm">
        <input type="hidden" id="serial" name="serial" value="${order}">
        <input type="hidden" id="pId" name="pId" value="${pId}">

        <table>

        <c:forEach items="${resultGameItem}" var="gameItemVO" varStatus="no">
                <tr>
                    <c:if test="${no.index%2 eq 0}">
                        <td rowspan="2">${gameItemVO.getSubTitle()}</td>
                    </c:if>
                        <td><input type="radio" id="answer" name="answer" value="${gameItemVO.getGiId()}">${gameItemVO.getContent()}</td>
                    <c:if test="${no.index%2 eq 0}">
                        <td rowspan="2"><button type="button" onclick="insertPlayItem()">다음</button></td>
                    </c:if>
                </tr>
        </c:forEach>

        </table>

    </form>

</body>
</html>
