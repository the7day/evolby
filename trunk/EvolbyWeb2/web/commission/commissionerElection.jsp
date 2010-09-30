<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Commission - Yours elections" />
</jsp:include>

<f:view>
    <h1>Yours elections</h1>
    <h:dataTable styleClass="elections" cellspacing="0" value="#{createElectionEvent.comElection}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="Name"/>
            </f:facet>
            <h:outputText value="#{item.name}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Election events"/>
            </f:facet>
            <h:outputLink value="viewEvents.jsp">
                events
                <f:param name="elecId" value="#{item.id}"/>
            </h:outputLink>
        </h:column>
    </h:dataTable>
                <br/>
    <h:outputLink styleClass="button" value="mainCommissioner.jsp">
        Menu
    </h:outputLink>
</f:view>

<jsp:include page="../footer.jsp"/>
