<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/22
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
      function validate()
      {
//          var username=document.getElementById("username1");
//          var password =document.getElementById("password1");
//          var repassword =document.getElementById("repassword1");

        var username =document.getElementsByName("username1")[0];
        var password =document.getElementsByName("password1")[0];
        var repassword =document.getElementsByName("repassword1")[0];
         if(username.value == "")
          {
            alert("username cant be blank!");
            return false; //返回false表单不会提交
          }

          if(password.value.length<6 ||password.value.length>10)
          {
            alert("length of password is invalid!");
            return false;
          }
        if(password.value != repassword.value)
        {
          alert("password not the same");
          return false;
        }
          return true;

//          var repassword
      }
    </script>
</head>
<body>
<form onsubmit="return validate()">
  username:<input type="text" name="username" id="username1"><br>
  password:<input type="psaaword" name="password" id="password1"><br>
  re-password:<input type="psaaword" name="repassword" id="repassword1"><br>
  <input type="submit" value="submit">
</form>

</body>
</html>
