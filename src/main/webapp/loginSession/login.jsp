<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/25
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/LoginSession" method="post">
  username:<input type="text" name="username" ><br>
  password:<input type="password" name="password"><br>
  authority:
  <select name="authority">
    <option value="1">common user</option>
    <option value="2">administrator</option>
  </select>
  <br>
  <input type="submit" value="submit">
</form>

</body>
</html>
