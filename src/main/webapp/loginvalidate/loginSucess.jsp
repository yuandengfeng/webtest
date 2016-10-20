<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/23
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
用户名： <%=request.getAttribute("username")%><br>
密码：<%=request.getAttribute("password")%><br>
性别：<%=request.getAttribute("gender")%><br>
地址：<%=request.getAttribute("address")%><br>
兴趣：<% String[] interest=(String[])request.getAttribute("interest");
for(String str:interest)
{
%>

<%= str %>&nbsp;&nbsp;

<%} %>

</body>
</html>
