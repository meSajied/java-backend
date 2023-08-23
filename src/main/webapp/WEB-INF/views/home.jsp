<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
  </head>
  <body>
    <% List<String> cc = (List<String>)request.getAttribute("f"); 
      for(String c: cc) {%>
    <h1><%= c %></h1>
    <% } %>
  </body>
</html>
