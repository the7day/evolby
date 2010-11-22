<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<jsp:include page="../header.jsp" />
<f:view>
    <h:messages />
    <h1><h:outputText value="Election results"/></h1>
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