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

    <h2>Nominate yourself</h2>
    <h:form>
        <table class="form" cellspacing="1">
            <tbody>
                <tr>
                    <th>Election event:</th>
                    <td>
                        <h:selectOneMenu value="#{nominating.eventId}">
                            <f:selectItems value="#{nominating.selectItems}"/>
                        </h:selectOneMenu>
                    </td>
                </tr>
                <tr>
                    <th>Programme:</th>
                    <td><h:inputTextarea value="#{nominating.programme}" /></td>
                </tr>
                <tr>
                    <td colspan="2" class="button">
                        <h:commandButton value="Nominate" action="#{nominating.nominate}" />
                    </td>
                </tr>
            </tbody>
        </table>
    </h:form>
</f:view>
<jsp:include page="../footer.jsp" />

