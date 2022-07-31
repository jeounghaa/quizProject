<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/06/12
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>테스트 결과는?</title>
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        function goMain(){
            window.location.href = "../user/main.do";
        }
    </script>
</head>
<body>
결과는..!<br/>
${resultVO.value1} 입니다!
<br/><br/>
<input type="button" value="메인으로" onclick="goMain()">
</body>
</html>
