<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="header.jsp" />
<f:view>
    <h1>E-volby</h1>
    <span>Welcome:</span>
    <h:outputText value="#{default.usersName}" />
    <h:form>
    <h:commandLink value="Continue" action="voters" rendered="#{default.voter}" />
    <h:commandLink value="Continue" action="commissioners" rendered="#{default.commissioner}" />
    <h:commandLink value="Continue" action="administrators" rendered="#{default.administrator}" />
    </h:form>
</f:view>

<jsp:include page="footer.jsp"/>


