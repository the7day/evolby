<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="header.jsp">
  <jsp:param name="title" value="E-volby" />
</jsp:include>
   
  <h1>E-volby</h1>
  <a class="button" href="faces/voters/mainVoter.jsp">Voter</a><br/>
  <a class="button" href="faces/commission/mainCommissioner.jsp">Commissioner</a><br/>
  <a class="button" href="faces/administrator/mainAdmin.jsp">Administrator</a>

<jsp:include page="footer.jsp"/>


       
