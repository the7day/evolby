<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<jsp:include page="../header.jsp">
  <jsp:param name="title" value="Voter - Voting " />
</jsp:include>

<f:view>
    <h1><h:outputText value="Voting"/></h1>
    <f:verbatim>
        <jsp:plugin type="applet"
        archive="VoteApplet.jar"
        code="voteapplet.Main"
        codebase=""
        width="250"
        height="350"
        jreversion="1.5"
        >
            <jsp:params>
                    <jsp:param name="jnlp_href" value="VoteApplet_browser.jnlp" />
                    <jsp:param name='login' value='${voting.login}' />
                    <jsp:param name='token' value='${voting.token}' />
                    <jsp:param name='eventId' value='${voting.eventId}' />
            </jsp:params>
            <jsp:fallback>
                <B>Unable to start plugin!</B>
            </jsp:fallback>
        </jsp:plugin>
    </f:verbatim>
</f:view>

<jsp:include page="../footer.jsp" />
