<%@ page import="javabean.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/22
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<% Person p = (Person)request.getAttribute("person");
  System.out.println(p.getName());
%>



</body>
</html>
