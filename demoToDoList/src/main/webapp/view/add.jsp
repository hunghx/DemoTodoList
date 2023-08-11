<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 8/11/2023
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New task</h1>
<form action="<%=request.getContextPath()%>/TodoController" method="post" enctype="multipart/form-data">
    <label>Title</label>
    <input type="text" name="title">
    <br>
    <label>Image</label>
    <input type="file" name="image">
    <br>
    <label>Content</label>
    <textarea name="content"  cols="30" rows="10"></textarea>
    <br>
    <input type="submit" value="ADD" name="action">
</form>
</body>
</html>
