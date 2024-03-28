<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <h1>${header}</h1>
  </head>
  <body>
    <!--<% List<String> cc = (List<String>)request.getAttribute("f"); 
      for(String c: cc) {%>
    <h1><%= c %></h1>
    <% } %> -->

    ${f}

    <div>${user.email}</div>
    <div>${user.name}</div>

    <c:forEach var="item" items="${f}" >
      <h2>${item}</h2>
    </c:forEach>
  </body>
</html>
