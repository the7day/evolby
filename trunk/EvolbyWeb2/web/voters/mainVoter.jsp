<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Voter - Main" />
</jsp:include>

<f:view>
    <h1>Main voter</h1>
    <p>Welcome voter, please choose one of following option.</p>
    <ul class="buttons">
        <li>
            <h:outputLink value="nominating.jsp">
                nominate
            </h:outputLink>
        </li>
        <li>
            <h:outputLink  value="voting.jsp">
                vote
            </h:outputLink>
        </li>
        <li>
            <h:outputLink  value="endedEvents.jsp">
                results
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
