<%--
  Created by IntelliJ IDEA.
  User: 31777
  Date: 2019/1/24
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传</title>
    <script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
    <script type="text/javascript">
            function showStatus() {
            var intervalId = setInterval(function () {
                $.get("user/getStatus.do", {}, function (data, status) {
                    console.log(data);
                    var percent = data.percent;
                    if (percent >= 100) {
                        clearInterval(intervalId);
                        percent = 100;//不能大于100
                    }
                    $("#result").width(percent + "%");
                }, "json");
            }, 100);
            return;
        }

    </script>
</head>
<body>
<!--  -->
<form action="user/fileUpload3.do" method="POST" enctype="multipart/form-data" onsubmit="showStatus()">
    <div id="uploadDiv">
        <input type="file" name="file" multiple id="uploadFile"/>
    </div>

    <input type="submit" value="提交"/>

</form>

<div style="border:black solid 1px; width: 800px;height: 10px;">
    <div id="result" style="height: 8px;background: green;position: relative; top: 1px;left: 1px;"></div>
</div>

</body>
</html>
