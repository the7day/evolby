<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Commission - Add voter" />
</jsp:include>

<f:view>
    <h1>Add voter</h1>
    <h:form>
        Voter :
        <h:selectOneMenu id="selectCom" value="#{createElectionEvent.voterLogin}" >
            <f:selectItems value="#{createElectionEvent.voterSel}" />
        </h:selectOneMenu>
        <br />
        <h:commandButton value="Add" action="#{createElectionEvent.addVoter}"/>
    </h:form>
        <h:dataTable styleClass="elections" cellspacing="0" value="#{createElectionEvent.eventVoters}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="login"/>
            </f:facet>
            <h:outputText value="#{item.login}"/>
        </h:column>
    </h:dataTable>
    <h:outputLink styleClass="buttons" value="viewEvent.jsp">
        Back
        <f:param name="evenId" value="#{createElectionEvent.eventId}"/>
    </h:outputLink>
</f:view>

<jsp:include page="../footer.jsp"/>

