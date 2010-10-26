<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="header.jsp" />
<f:view>
    <h1>E-volby</h1>
    <span>Welcome:</span>
    <h:outputText value="#{default.usersName}" />
    <h:form>
    <h:commandLink value="Continue voter" action="voters" rendered="#{default.voter}" /><br/>
    <h:commandLink value="Continue commissioner" action="commissioners" rendered="#{default.commissioner}" /><br/>
    <h:commandLink value="Continue administrator" action="administrators" rendered="#{default.administrator}" /><br/>
    </h:form>
</f:view>

<jsp:include page="footer.jsp"/>


