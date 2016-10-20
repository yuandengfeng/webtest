<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/22
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javabean.Person" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="person" class="javabean.Person" scope="request"></jsp:useBean>
<jsp:getProperty name="person" property="name"></jsp:getProperty><br>
<jsp:getProperty name="person" property="age"></jsp:getProperty><br>
<jsp:getProperty name="person" property="address"></jsp:getProperty><br>


<jsp:setProperty name="person" property="name" value="lisi"></jsp:setProperty>
<jsp:getProperty name="person" property="name"/><br>

<%--<jsp:forward page="javabean2.jsp"></jsp:forward>--%>


</body>
</html>
