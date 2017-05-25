<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>
<body>
<table>
    <tr>
        <td>key：<input id = "key" type = "text" ></td>
        <td><input type = "button" value="获取值" onclick="getVal()"></td>
    </tr>
    <tr>
        <td>result：<input id="result" type = "text" ></td>
    </tr>
</table>
</body>
<script>
    var  httpUrl = "<%=basePath%>/config";
    function  getVal(){
        var  data = {"key":$("#key").val()};
        $.get(
                httpUrl,
                data,
                function(result){
                    $("#result").val(result);
                }
        );
    }
</script>
</html>
