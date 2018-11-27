<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>列表页面</title>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<c:if test="${empty requestScope.users}">
    没有任何用户信息
</c:if>
<c:if test="${!empty requestScope.users}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.id }</td>
                <td>${user.name }</td>
                <td>${user.password }</td>
                <td>${user.email }</td>
                <td><a href="user/${user.id}">Edit</a></td>
                <td><a class="delete" href="user/${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<br><br>

<a href="user">Add New User</a>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("form").attr("action", href).submit();
            return false;
        });
    })
</script>
</body>
</html>