<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Commission - Main" />
</jsp:include>

<f:view>
    <h1>Main commissioner</h1>
    <p>Welcome commissioner, please choose one of following option.</p>
    <ul class="buttons">
        <li>
            <h:outputLink value="commissionerElection.jsp">
                My election
            </h:outputLink>
        </li>
        <li>
            <h:form>
                <h:commandLink value="logout" action="#{default.logout}"/>
            </h:form>
        </li>
    </ul>
</f:view>

<jsp:include page="../footer.jsp"/>
