<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<jsp:include page="../header.jsp" />
<f:view>
    <div class="menu">
        <ul class="buttons">
            <li>
                <h:outputLink value="nominating.jsf">
                    nominate
                </h:outputLink>
            </li>
            <li>
                <h:outputLink  value="voting.jsf">
                    vote
                </h:outputLink>
            </li>
            <li>
                <h:outputLink  value="endedEvents.jsf">
                    results
                </h:outputLink>
            </li>
            <li>
                <h:form>
                    <h:commandLink value="logout" action="#{default.logout}"/>
                </h:form>
            </li>
        </ul>
        <h1>Results</h1>
    </div>
    <h:messages styleClass="message" />
    
    <h:dataTable styleClass="elections" cellspacing="1" value="#{generatingResults.electionEventResults}" var="item">
        <h:column>
            <f:facet name="header">
                <h:outputText value="Candidate"/>
            </f:facet>
            <h:outputText value="#{item.candidate}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Votes"/>
            </f:facet>
            <h:outputText value="#{item.votes}"/>
        </h:column>
        <h:column>
            <f:facet name="header">
                <h:outputText value="Successful" />
            </f:facet>
            <h:outputText value="#{item.elected}"/>   

            
        </h:column>
    </h:dataTable>
        <h:outputText value="1-Elected,2-not enough space, 3- did not satisfy conditions"/>
</f:view>


<jsp:include page="../footer.jsp" />