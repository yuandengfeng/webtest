<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/4
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">

    var xmlHttpRequest =null;
    function ajaxSubmit()
    {
//      alert(window.ActiveXObject);

      if(window.ActiveXObject)
      {
//        alert("aaa");
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
      }else if(window.XMLHttpRequest)
      {
//        alert("bbb");
        xmlHttpRequest = new XMLHttpRequest();
      }

      if(null != xmlHttpRequest)
      {
//        alert("ccc");
          var v1=document.getElementById("value1ID").value;
          var v2=document.getElementById("value2ID").value;

//       xmlHttpRequest.open("GET","../AjaxServlet?v1="+v1+"&v2="+v2,true); //true表示异步
          xmlHttpRequest.open("POST","../AjaxServlet",true); //true表示异步

        //关联好ajax回调函数
       xmlHttpRequest.onreadystatechange = ajaxCallback;
        //真正向服务器发送数据
//        xmlHttpRequest.send(null);//GET请求
          xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//post请求必须加上这一行
          xmlHttpRequest.send("v1="+v1+"&v2="+v2);
      }


    }

    function ajaxCallback()
    {
//      alert("ddd");
     if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200)
     {
//         alert("eee");
         var responseText = xmlHttpRequest.responseText;
         document.getElementById("div1").innerHTML=responseText;

     }
    }


  </script>
</head>
<body>

  <input type="button" value="get content from server" onclick="ajaxSubmit();"><br>
  <input type="text" name="value1" id="value1ID"><br>
  <input type="text" name="value2" id="value2ID"><br>

  <div id="div1"></div>

</body>
</html>
