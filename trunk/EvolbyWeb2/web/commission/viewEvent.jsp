<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Commission - View election event" />
</jsp:include>

<f:view>
    <h1>View event</h1>
    <br />
    <h2>Event id : <h:outputText value="#{createElectionEvent.eventId}" /></h2>
    <h:form>
        <h3>Attributes</h3>
        <table class="form">
        <tbody>
            <tr>
                <th>Event name</th>  <td><h:inputText value="#{createElectionEvent.eventName}" /></td>
            </tr>
            <tr>
                <th>Event info</th>  <td><h:inputTextarea value="#{createElectionEvent.info}" /></td>
            </tr>
        </tbody>
        </table>
        <h:inputHidden value="#{createElectionEvent.eventId}"/>
        <h:commandButton value="Change" action="#{createElectionEvent.changeEvent}" />
    </h:form>
    <h:form>
        <h3>Controls</h3>
        <ul class="buttons">
            <li>
                <h:commandLink value="Start nominating" action="#{nominating.startNominating}" />
            </li>
            <li>
                <h:commandLink value="End nominating" action="#{nominating.endNominating}" />
            </li>
            <li>
                <h:commandLink value="Start voting" action="#{voting.startVoting}" />
            </li>
            <li>
                <h:commandLink value="End voting" action="#{voting.endVoting}" />
            </li>
        </ul>
    </h:form>
    <h3>Candidates</h3>
    <h:dataTable styleClass="elections" cellspacing="0" value="#{nominating.candidates}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="login"/>
            </f:facet>
            <h:outputText value="#{item.login}"/>
        </h:column>
    </h:dataTable>
    <h3>Voters in event</h3>
    <h:dataTable styleClass="elections" cellspacing="0" value="#{createElectionEvent.eventVoters}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="login"/>
            </f:facet>
            <h:outputText value="#{item.login}"/>
        </h:column>
    </h:dataTable>
    <h:outputLink styleClass="button" value="addVoter.jsp">
        Add voter
    </h:outputLink>
    <br />
    <h:outputLink styleClass="button" value="mainCommissioner.jsp">
        Menu
    </h:outputLink>
</f:view>

<jsp:include page="../footer.jsp"/>
