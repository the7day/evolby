<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Voter - Nominating" />
</jsp:include>

<f:view>
    <h1>
        <h:outputText value="Nominating"/>
    </h1>
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
