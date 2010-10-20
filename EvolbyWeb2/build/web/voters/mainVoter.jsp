<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<jsp:include page="../header.jsp" />
<f:view>

    <h:messages />
    <h1>Main voter</h1>
    <p>Welcome voter, please choose one of following option.</p>
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




</f:view>
    <jsp:include page="../footer.jsp" />