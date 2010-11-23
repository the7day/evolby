<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="header.jsp" />
<f:view>
    <h1>E-volby welcome page</h1>
    <br />
    <span>Welcome </span>
    <h:outputText value="#{default.usersName}" />
    <h:form>
    <h:commandLink value="Click here to continue, voter" action="voters" rendered="#{default.voter}" />
    <h:commandLink value="Click here to continue, commissioner" action="commissioners" rendered="#{default.commissioner}" />
    <h:commandLink value="Click here to continue, administrator" action="administrators" rendered="#{default.administrator}" />
    </h:form>
</f:view>

<jsp:include page="footer.jsp"/>


