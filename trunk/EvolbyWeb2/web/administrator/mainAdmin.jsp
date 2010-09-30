<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Admin - Main" />
</jsp:include>

<f:view>
    <h1>Main Administrator</h1>
    <p>Welcome administrator, please choose one of following option.</p>
    <ul class="buttons">
        <li>
            <h:outputLink value="createElectionPage.jsp">
                create election
            </h:outputLink>
        </li>
        <li>
            <h:outputLink value="viewElections.jsp">
                View elections
            </h:outputLink>
        </li>
        <li>
            <h:form>
                <h:commandLink value="logout" action="#{default.logout}"/>
            </h:form>
        </li>
    </ul>
</f:view>

<jsp:include page="../footer.jsp" />
