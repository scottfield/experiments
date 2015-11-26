<%--
  Created by IntelliJ IDEA.
  User: jackie
  Date: 2015/9/10
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery experiments</title>
      <script src="resources/jquery-1.9.1.min.js"></script>
      <script src="resources/jquery.validate.js"></script>
  </head>
  <body>
    <p>form validate</p>

    <form action="" id="testform">
        <input type="text" name="username"/>
        <input type="text" name="sex"/>
        <input type="password" name="password"/>
        <input type="submit" value="submit"/>
    </form>
    <script>
        $(function() {
            $("#testform").validate({rules:{username:{required:true,minlength:10}}});
        });
    </script>
  </body>
</html>
