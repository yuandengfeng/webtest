<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/23
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
错误信息如下：<br><br>
<% List<String> list=(List<String>) request.getAttribute("error");%>
<ul>
  <%
    for(String str:list)
    {
  %>
  <li><font color="#ff0000"><%=str %></font> </li>
  <% } %>
</ul>

</body>
</html>
