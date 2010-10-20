<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<jsp:include page="../header.jsp" />
<f:view>
    <h:messages />
    <h1>Election events</h1>

    <h:dataTable styleClass="elections" cellspacing="1" value="#{createElectionEvent.unfinishedElectionEvents}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="Name"/>
            </f:facet>
            <h:outputText value="#{item.name}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Id"/>
            </f:facet>
            <h:outputText value="#{item.id}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="nominating started"/>
            </f:facet>
            <h:outputText value="#{item.nominatingStarted}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="voting started"/>
            </f:facet>
            <h:outputText value="#{item.votingStarted}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="edit"/>
            </f:facet>
            <h:form>
                <h:commandLink value="view" action="#{createElectionEvent.viewEvent}">
                    <f:param name="eventId" value="#{item.id}"/>
                    <f:param name="elecId" value="#{createElectionEvent.elecId}"/>
                </h:commandLink>
            </h:form>
        </h:column>
    </h:dataTable>
                <br/>
    <ul class="buttons">
      <li>
        <h:outputLink  value="createNewEvent.jsf">
          Create new event
            <f:param name="elecId" value="#{createElectionEvent.elecId}"/>
        </h:outputLink>
      </li>
      <li>
        <h:outputLink styleClass="buttons" value="mainCommissioner.jsf">
            Menu
        </h:outputLink>
      </li>
    </ul>

</f:view>
<jsp:include page="../footer.jsp" />

