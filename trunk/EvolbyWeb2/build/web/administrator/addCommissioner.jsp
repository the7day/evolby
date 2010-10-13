<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp" />

<f:view>
    <h1>Add commissioner</h1>
    <h:form>
      <h:inputHidden value="#{createElection.electionId}"/>
      <table class="form">
        <tbody>
          <tr>
            <th>Commissioner:</th>
            <td><h:selectOneMenu id="selectCom" value="#{createElection.stringperson}" >
            <f:selectItems value="#{createElection.personSel}" />
        </h:selectOneMenu></td>
          </tr>
          <tr>
            <td colspan="2" class="button">
              <h:commandButton value="Add" action="#{createElection.addCommissioner}"/>
            </td>
          </tr>
        </tbody>
      </table>
            <br/><br />
      <h:outputLink styleClass="button" value="viewElection.jsf">

          <f:param name="electionId" value="#{createElection.electionId}"/>
          Back
      </h:outputLink>
    </h:form>
</f:view>
<jsp:include page="../footer.jsp" />


