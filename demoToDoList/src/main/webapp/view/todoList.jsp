<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>List Todo</h1>
<a href="<%=request.getContextPath()%>/TodoController?action=ADD">Add</a>
<table border="10" cellpadding="20" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Title</th>
        <th>Image</th>
        <th>Content</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="t" varStatus="item">
        <tr>
            <td>${item.count}</td>
            <td>${t.title}</td>
            <td><img width="100px" height="100px" style="object-fit: cover" src="<%=request.getContextPath()%>/upload/${t.imageUrl}" alt="anh"></td>
            <td>${t.content}</td>
            <td>${t.status?"Đã hoàn thành":"Chưa hoàn thành"}</td>
            <td><a href="<%=request.getContextPath()%>/TodoController?action=EDIT&id=${t.id}">Edit</a></td>
            <td><a onclick="return confirm('do you want to delete this task ? ')" href="<%=request.getContextPath()%>/TodoController?action=DELETE&id=${t.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
