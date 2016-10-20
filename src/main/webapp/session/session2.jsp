<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/19
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
 String name=request.getParameter("username");
  session.setAttribute("logName",name);
%>
你的名字"<%=name%>"已经写入session
<br>
<a href="session3.jsp">check</a>
</body>
</html>
