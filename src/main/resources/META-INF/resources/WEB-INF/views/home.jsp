<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Now Showing</title>

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.x-git.min.js"></script>
</head>

<body>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            <div class="row">
                <div class="col-xs-4">
                    <input type="text" name="keyword" id="originUrl" value="${ cri.keyword }">
                    <button id="changeBtn">변환</button>
                </div>
                <div class="col-xs-8">
                    <h2 class="post-title">title</h2>
                    <label id="check"></label>
                    <hr style="border-color: black">
                    <h3 class="post-subtitle" id="shortenUrl">
                        ㅇㅇㅇㅇㅇㅇㅇ
                    </h3>
                    <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 24, 2014</p>
                </div>
            </div>
        </div>
    </div> <!-- /.row -->
</div><!-- /.container -->

<!-- jQuery -->

<script type="text/javascript">
    $(document).ready(function() {
        console.log("asdf");

        $("#changeBtn").on("click", function(){
            var originUrl = $("#originUrl").val();
            console.log('a');

            $.ajax({
                type: 'post',
                url: '/shortenUrl',
                headers: {
                    "Content-Type": "application/json",
                    "X-HTTP-Method-Override": "POST" },
                data: JSON.stringify({originUrl: originUrl}),
                dataType: 'json',
                success: function(data){
                    console.log("result : " + data);
                    console.log("result : " + data.data.shortIdx);

                    $("#check").html(data.data.shortIdx.toString());
                }});
        });
    });
</script>
</body>
</html>

