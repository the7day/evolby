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
        <h1>Nominate</h1>
    </div>
    <h:messages styleClass="message" />

    <table class="form" cellspacing="1">
        <tbody>
            <tr>
                <th>Election event:</th>
                <td>
                    <h:selectOneMenu value="#{voting.eventId}">
                        <f:selectItems value="#{voting.selectItems}" />
                    </h:selectOneMenu>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="button">
                    <h:form>
                        <h:commandButton value="Vote" action="#{voting.goVote}" />
                    </h:form>
                </td>
            </tr>
        </tbody>
    </table>

</f:view>

<jsp:include page="../footer.jsp" />
