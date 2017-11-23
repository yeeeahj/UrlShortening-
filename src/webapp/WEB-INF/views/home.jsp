<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <%@include file="../include/header.jsp" %>
    <title>Now Showing</title>
</head>

<body>

<%@include file="../include/menu.jsp" %>
<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('/resources/img/post-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Now Showing</h1>
                    <hr class="small">
                    <span class="subheading">More Faster, More Simply, Enjoy the movie !</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <div class="row">
                <div class="col-xs-4">
                    <input type="text" name="keyword" id="keywordInput" value="${ cri.keyword }">
                    <button id="searchBtn">변환</button>
                </div>
                <div class="col-xs-8">
                    <h2 class="post-title">미녀와 야수</h2>
                    <hr style="border-color: black">
                    <h3 class="post-subtitle">
                        스크린에 의해 재탄생한 세기의 걸작!
                        전 세계가 기다려온 가장 아름다운 이야기!
                    </h3>
                    <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 24, 2014</p>
                </div>
            </div>
        </div>
    </div> <!-- /.row -->
</div><!-- /.container -->

<%@include file="../include/footer.jsp" %>

<script>

    $(document).ready(function () {
        // 검색버튼 이벤트 등록
        $("#searchBtn").on("click", function (event) {
            self.location = "listPage"
                + "?page=1"
                + "&searchType=" + $("select option:selected").val()
                + "&keyword=" + $("#keywordInput").val();
        });

        // 글작성 버튼 이벤트 등록
        $("#newBtn").on("click", function (event) {
            self.location = "register";
        });
    });

    var result = '${msg}';

    // 컨트롤러에서 보낸 msg가 SUCCESS라면 아래와 같은 팝업창을 띄운다.
    if (result == 'SUCCESS') {
        alert("처리가 완료되었습니다.");
    }

    $("#changeBtn").on("click", function(){
        var originUrl = $("#originUrl").val();

        $.ajax({
            type: 'post',
            url: '/shortenUrl/',
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST" },
            data: JSON.stringify({originUrl: originUrl}),
            dataType: 'text',
            success: function(result){
                console.log("result : " + result);

                if(result == 'SUCCESS'){
                    alert("수정되었습니다.");
                    getPage("/replies/" + bno + "/" + replyPage);
                }
            }});
    });

</script>



</body>

</html>

