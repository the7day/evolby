<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp" />

<f:view>
    <h:messages />
    <h1>View election</h1>
    <h2>Election info</h2>
    <table class="elections">
      <tbody>

        <tr>
          <th>Election name:</th>
          <td> <h:outputText value="#{createElection.election.name}"/></td>
        </tr>
        <tr>
          <th>Election type:</th>
          <td><h:outputText value="#{createElection.election.type}"/></td>
        </tr>
      </tbody>
    </table>

    <br/>
    <h2>Commisioners</h2>
    <h:dataTable styleClass="elections" cellspacing="0" value="#{createElection.electionCommissioners}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="First name"/>
            </f:facet>
            <h:outputText value="#{item.firstName}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Last name"/>
            </f:facet>
            <h:outputText value="#{item.lastName}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Login"/>
            </f:facet>
            <h:outputText value="#{item.login}"/>
        </h:column>
    </h:dataTable>
    <ul class="buttons">
    <li><h:outputLink value="addCommissioner.jsf">
        add commissioner
        <f:param name="electionId" value="#{createElection.electionId}"/>
    </h:outputLink></li>

    <li><h:outputLink value="viewElections.jsf">
        Back
    </h:outputLink></li>
    </ul>
</f:view>
<jsp:include page="../footer.jsp" />