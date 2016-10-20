<%--
  Created by IntelliJ IDEA.
  User: yuandengfeng
  Date: 2016/9/21
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡</title>


</head>
<body>

<form name="mqform" action="/SendDownServlet">
    mac :<input type="text" name="mac" placeholder="如D4EE07250B32"><br>
    <%--unixTime:<input type="text" name="unixTime"><br>--%>
    downtime:<input type="text" name="unixTime" placeholder="如2016-09-21 11:45:55" ><br>
    ip   :<input type="text" name="ip" placeholder="如192.168.96.1"><br>
    <input type="submit" value="submit" >&nbsp;&nbsp;&nbsp;
    <input type="reset" value="reset">

</form>



</body>
</html>
