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
                    <th>Event name</th>
                    <td><h:inputText value="#{createElectionEvent.eventName}" disabled="#{!createElectionEvent.renderStartNominating}"/></td>
                </tr>
                <tr>
                    <th>Event info</th>
                    <td><h:inputTextarea value="#{createElectionEvent.info}" disabled="#{!createElectionEvent.renderStartNominating}"/></td>
                </tr>
            </tbody>
        </table>
        <h:inputHidden value="#{createElectionEvent.eventId}"/>
        <h:commandButton value="Change" action="#{createElectionEvent.changeEvent}" disabled="#{!createElectionEvent.renderStartNominating}"/>
    </h:form>
    <h:form>
        <h3>Controls</h3>
        <ul class="buttons">
            <li>
                <h:commandLink value="Start nominating" action="#{nominating.startNominating}" rendered="#{createElectionEvent.renderStartNominating}" />
            </li>
            <li>
                <h:commandLink value="End nominating" action="#{nominating.endNominating}" rendered="#{createElectionEvent.renderEndNominating}" />
            </li>
            <li>
                <h:commandLink value="Start voting" action="#{voting.startVoting}" rendered="#{createElectionEvent.renderStartVoting}" />
            </li>
            <li>
                <h:commandLink value="End voting" action="#{voting.endVoting}" rendered="#{createElectionEvent.renderEndVoting}" />
            </li>
        </ul>
    </h:form>
    <h3>Candidates</h3>
    <h:form>
        <h:dataTable styleClass="elections" cellspacing="0" value="#{createElectionEvent.candidatesModel}" var="item">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="login"/>
                </f:facet>
                <h:outputText value="#{item.login}"/>
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="role" />
                </f:facet>
                <h:outputText value="#{item.candidateRole}" />
            </h:column>
            <h:column>
                <h:commandLink value="Remove" action="#{createElectionEvent.deleteCandidate}" />
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
                <h:commandLink value="Remove" action="#{voting.deleteVoter}"  >

                </h:commandLink>
            </h:column>
        </h:dataTable>
    </h:form>
    <h:outputLink styleClass="button" value="addVoter.jsf">
        Add voter
    </h:outputLink>
    <h:form rendered="#{!createElectionEvent.renderStartNominating}">
        <h3><h:outputText value="#{createElectionEvent.commissionersAgreeTableHeader}"/></h3>
        <h:dataTable styleClass="elections" cellspacing="0" value="#{createElectionEvent.agreedCom}" var="item">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="login"/>
                </f:facet>
                <h:outputText value="#{item.login}" />
            </h:column>
        </h:dataTable>
    </h:form>


    <br />
    <h:outputLink styleClass="button" value="mainCommissioner.jsf">
        Menu
    </h:outputLink>

</f:view>
<jsp:include page="../footer.jsp" />
