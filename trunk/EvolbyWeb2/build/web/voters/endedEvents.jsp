<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<jsp:include page="../header.jsp" />

<f:view>
    <h:messages />
    <h1><h:outputText value="Election events results"/></h1>
    <h:dataTable styleClass="elections" cellspacing="1" value="#{createElectionEvent.endedEvents}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="Id"/>
            </f:facet>
            <h:outputText value="#{item.id}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Name"/>
            </f:facet>
            <h:outputText value="#{item.name}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Result"/>
            </f:facet>
            <h:form>
                <h:commandLink value="result" action="#{createElectionEvent.viewResultEvent}">
                    <f:param name="eventId" value="#{item.id}"/>
                </h:commandLink>
            </h:form>
        </h:column>
    </h:dataTable>
</f:view>
<jsp:include page="../footer.jsp" />