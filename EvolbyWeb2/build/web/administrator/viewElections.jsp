<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp" />
<f:view>
    <h1>View elections</h1>
    <h:dataTable cellspacing="1" styleClass="elections" value="#{createElection.elections}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="Name"/>
            </f:facet>
            <h:outputText value="#{item.name}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="View election"/>
            </f:facet>
            <h:outputLink  value="viewElection.jsf">
                view
                <f:param name="electionId" value="#{item.id}"/>
            </h:outputLink>
        </h:column>
    </h:dataTable>
                <br/>
    <h:outputLink styleClass="button" value="mainAdmin.jsf">Menu</h:outputLink>
</f:view>

<jsp:include page="../footer.jsp" />
