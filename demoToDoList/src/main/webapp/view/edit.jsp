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
<h1>Edit task</h1>
<form action="<%=request.getContextPath()%>/TodoController" method="post" enctype="multipart/form-data">
    <label>ID</label>
    <input type="text" name="id" readonly value="${task.id}">
    <br>
    <label>Image</label>
    <input type="file" name="image" value="${task.name}">
    <br>
    <label>Content</label>
    <textarea name="content" cols="30" rows="10">${task.content}</textarea>
    <br>
    <label>Status</label>
    <select name="status">
        <option value="true"  ${task.status==true?'selected':''}>Đã hoàn thành</option>
        <option value="false" ${task.status==true?'':'selected'}>Chưa hoàn thành</option>
    </select>
    <br>
    <input type="submit" value="UPDATE" name="action">
</form>
</body>
</html>
