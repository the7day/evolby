<%-- 
  Document   : header
  Created on : 17.11.2009, 11:27:23
  Author     : lordondrak
--%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="robots" content="index,follow" />
        <meta http-equiv="pragma" content="no-cache" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=request.getParameter("title")%></title>
        <link href="/EvolbyWeb2/css/screen.css" media="screen" rel="stylesheet" type="text/css" />
    </head>
    <body>
      <div class="main">
        <div class="head">
          <ul>
            <li><a href="/EvolbyWeb2">Home</a></li>
            <li><a href="faces/voters/mainVoter.jsp">Voter demo</a></li>
            <li><a href="faces/commission/mainCommissioner.jsp">Commisioner demo</a></li>
            <li><a href="faces/administrator/mainAdmin.jsp">Administrator demo</a></li>
          </ul>
          &nbsp;
        </div>
        <div class="content">
