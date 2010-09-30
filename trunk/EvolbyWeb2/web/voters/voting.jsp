<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Voter - Voting" />
</jsp:include>

<f:view>
    <h1><h:outputText value="Voting"/></h1>
    <h:form>
        Election event :
        <h:selectOneMenu value="#{voting.eventId}">
            <f:selectItems value="#{voting.selectItems}"/>
        </h:selectOneMenu>
        <h:commandLink value="Vote" action="#{voting.goVote}" />
    </h:form>
</f:view>

<jsp:include page="../footer.jsp" />
