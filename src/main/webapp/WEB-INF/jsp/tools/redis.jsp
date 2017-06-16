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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/redis.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>
<body>
<%--<header class="header">--%>
<%--<nav class="mynav">--%>
<%--<img src="<%=basePath%>img/redis-white.png">--%>
<%--</nav>--%>
<%--</header>--%>
<div class="mycontent">
    <div id="hash">
        HASH:<input type="text" id="hkey">
        <input type="button" value="添加键" onclick="addTr();">
        <table class="mygridtable" width="80%;" id="mygridtable">
            <tr>
                <th>键</th>
                <th>值</th>
                <th>操作</th>
            </tr>
            <tr>
                <td><input type="text" name="key"></td>
                <td><input type="text" name="value"></td>
                <td><input type="button" value="删除" onclick="delTr(this)"></td>
            </tr>
        </table>
        <button onclick="saveHash()">保存</button>
    </div>
</div>
</body>
<script>
    var httpUrl = "<%=basePath%>/redis/add";
    function addRedis() {
        var data = {"key": $("#key").val(), "content": $("#content").val()};
        $.get(
                httpUrl,
                data,
                function (result) {
                    $("#result").html(result);
                }
        );
    }
    function addTr() {
        var tr = $(".mygridtable").find("tr").eq(1).clone();
        tr.find("input[type='text']").val("");
        $(".mygridtable").append(tr);
    }

    function delTr(obj) {
        $(obj).parent().parent().remove();
    }

    function saveHash() {
        var myHash = getHashData();
        console.log(myHash);
        $.ajax({
            url: "<%=basePath%>/redis/hmet",
            type: "POST",
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(myHash),
            success: function (result) {
                alert(result);
            },
            error: function (e) {
                alert("出现错误 ，请重试");
            }
        });
    }
    function getHashData() {
        var hkey = $("#hkey").val();
        var r_keys = $("input[name='key']");
        var r_values = $("input[name='value']");
        var map = {};
        for (var i = 0; i < r_keys.length; i++) {
            map[r_keys[i].value] = r_values[i].value;
        }
        var myHash = {};
        myHash.hkey = hkey;
        myHash.map = map;
        return myHash;
    }
</script>
<div style="display: none;">
    <p>redis字符串操作</p>

    <div>key:<input type="text" id="key"></div>
    <div>value:<input type="text" id="content"></div>
    <span id="result" style="color: red"></span>

    <div><input type="button" value="添加" onclick="addRedis()"></div>
</div>
</html>
