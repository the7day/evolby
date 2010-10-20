<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp" />

<f:view>
    <h:messages />
    <h1>Create election</h1>
    <h:form>
      <table class="form">
        <tbody>
          <tr>
            <th>Election name:</th>
            <td><h:inputText id="name" requiredMessage="Value Name is required." value="#{createElection.name}"
        required="true" label="Name"/></td>
          </tr>
          <tr>
            <th>Type:</th>
            <td>
                <h:selectOneRadio id="type" value="#{createElection.currentType}">
                  <f:selectItem itemLabel="Internet" itemValue="Internet" />
                  <f:selectItem itemLabel="Local" itemValue="Local" />
                </h:selectOneRadio>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="button">
              <h:commandButton value="Create" action="#{createElection.create}"/>
            </td>
          </tr>
        </tbody>
      </table>
    </h:form>
</f:view>

<jsp:include page="../footer.jsp" />