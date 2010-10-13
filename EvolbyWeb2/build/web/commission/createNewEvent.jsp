<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp" />
<f:view>
    <h1>Create election event</h1>
    <h:form>
      <h:inputHidden value="#{createElectionEvent.elecId}" />
      <table class="form">
        <tbody>
          <tr>
            <th>Event name:</th>
            <td><h:inputText value="#{createElectionEvent.eventName}" /></td>
          </tr>
          <tr>
            <th>Info:</th>
            <td> <h:inputTextarea value="#{createElectionEvent.info}" /></td>
          </tr>
          <tr>
            <td class="button" colspan="2">
               <h:commandButton value="Create" action="#{createElectionEvent.createEvent}"/>
            </td>
          </tr>
        </tbody>
      </table>
         
       
    </h:form>
    <br/>
    <h:outputLink styleClass="button" value="mainCommissioner.jsf">
        Menu
    </h:outputLink>
</f:view>
<jsp:include page="../footer.jsp" />

