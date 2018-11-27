<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>input</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/user" method="POST" modelAttribute="user">

    <c:if test="${user.id != null}">
        <%--传递一个 id 参数，相当于 hidden输入框--%>
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT">
    </c:if>

    Name: <form:input path="name"/><br>

    <c:if test="${user.id ==null}">
        Password：<form:password path="password"/><br>
    </c:if>

    Email: <form:input path="email"/><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>