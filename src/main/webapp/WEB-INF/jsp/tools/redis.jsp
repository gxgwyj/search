<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>redis测试工具</title>
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>
<body>
<table border="1px">
    <tr>
        <td>key:<input type="text" id="key"></td>
        <td>value:<input type = "text" id="content"></td>
        <td><input type="button" value="+" onclick="addRedis()"></td>
        <td><span id="result" style="color: red"></span></td>
    </tr>
</table>
</body>
<script>
    var  httpUrl = "<%=basePath%>/redis/add";
    function  addRedis(){
        var  data = {"key":$("#key").val(),"content":$("#content").val()};
        $.get(
                httpUrl,
                data,
                function(result){
                    $("#result").html(result);
                }
        );
    }
</script>
</html>
