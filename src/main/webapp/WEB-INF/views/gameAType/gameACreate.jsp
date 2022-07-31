<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jeoungha
  Date: 2022/05/26
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>고르기 게임 생성</title>
    <link rel="stylesheet" type="text/css" href="../../static/css/GameAType/create.css?after">
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>

    <script type="text/javascript">
        let count = 0;

        function addData() {
            const title = $('#title').val();
            const intro = $('#intro').val();

            $.ajax({
                url: "/gameAType/addMain.ajax",
                type: "POST",
                data: $("#gameA").serialize(),
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                success: function (data) {
                    count += 1;

                    console.log("success");
                    $('#title').attr("readonly",true);
                    $('#intro').attr("readonly",true);
                    // 질문 및 대답 부분 초기화
                    $('#question').val('');
                    $('#answer1').val('');
                    $('#answer2').val('');

                    // 마지막 질문일 경우
                    if(count == 2){
                        console.log("마지막질문!!");
                        $('#result').text('완료');
                    }
                    else if(count == 3){
                        window.location.href = "../user/main.do";
                        console.log("finish.");
                    }
                },
                error: function (data) {
                    console.log(data.msg);
                    console.log("fail");
                }
            })
        }
    </script>
    <script type="text/css">
        html, body {
            margin-left: 100px;
        }
    </script>
</head>
<body>
    <br /><h2>고르기 게임 생성하기</h2><br />
    <p>질문은 3개까지 가능합니다.</p>


    <form id="gameA" action="addGame.do">
        <input id="title" type="text" placeholder="테스트명을 입력해주세요." size="" name="title"><br /> <%-- title --%>
        <textarea id="intro" placeholder="테스트에 대한 설명을 입력해주세요." cols="50" rows="5" name="intro"></textarea><br /><br /><br /> <%-- intro --%>
        <br/>
        <h4>결과 값</h4>
        <p>결과 값은 2개 설정 가능합니다.</p>
        <br/>
        1) <input type="text" name="value1" id="val1">
        <br/>
        2)<input type="text" name="value2" id="val2">
<%--        <br/>--%>
<%--        3)<input type="text" name="value3" id="val3">--%>
        <br/><br/>
        <h3>문제</h3>
        <div id="main">
            <div id='test1'>
                <input id='question' type='text' placeholder='질문을 입력해주세요.' name="subTitle">
                <br />
                <input id='answer1' type='text' placeholder='선택지1를 입력해주세요.' name="content1"/>
                <select name="score1">
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>
                <br />
                <input id='answer2' type='text' placeholder='선택지2를 입력해주세요.' name="content2"/>
                <select name="score2">
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>
                <br /><br />
            </div>
        </div>
        <button id="result" type="button" onclick="addData()">다음</button>
    </form>

</body>
</html>
