<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<jsp:include page="../header.jsp" />



<f:view>

    <h:messages />
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
                <h:commandLink value="Start nominating" action="#{nominating.startNominating}" rendered="#{nominating.renderStartNominating}" />
            </li>
            <li>
                <h:commandLink value="End nominating" action="#{nominating.endNominating}" rendered="#{nominating.renderEndNominating}" />
            </li>
            <li>
                <h:commandLink value="Start voting" action="#{voting.startVoting}" rendered="#{nominating.renderStartVoting}" />
            </li>
            <li>
                <h:commandLink value="End voting" action="#{voting.endVoting}" rendered="#{nominating.renderEndVoting}" />
            </li>
        </ul>
    </h:form>
    <h3>Candidates</h3>
    <h:form>
        <h:dataTable styleClass="elections" cellspacing="0" value="#{nominating.candidatesModel}" var="item">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="login"/>
                </f:facet>
                <h:outputText value="#{item.login}"/>
            </h:column>
            <h:column>
                <h:commandLink value="Odstranit" action="#{nominating.deleteCandidate}" />
            </h:column>

        </h:dataTable>
    </h:form>
    <h3>Voters in event</h3>
    <h:form>
        <h:dataTable styleClass="elections" cellspacing="0" value="#{voting.allVotersModel}" var="item">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="login"/>
                </f:facet>
                <h:outputText value="#{item.login}"/>
            </h:column>
            <h:column>
                <h:commandLink value="Odstranit" action="#{voting.deleteVoter}"  >

                </h:commandLink>
            </h:column>
        </h:dataTable>
    </h:form>
    <h:outputLink styleClass="button" value="addVoter.jsf">
        Add voter
    </h:outputLink>
    <br />
    <h:outputLink styleClass="button" value="mainCommissioner.jsf">
        Menu
    </h:outputLink>

</f:view>
<jsp:include page="../footer.jsp" />
