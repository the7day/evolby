<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<jsp:include page="../header.jsp" />
<f:view>
    <h:messages styleClass="message" />
    <div class="menu">
        <ul class="buttons">
            <li>
                <h:outputLink value="nominating.jsf">
                    Nominovat
                </h:outputLink>
            </li>
            <li>
                <h:outputLink  value="voting.jsf">
                    Volit
                </h:outputLink>
            </li>
            <li>
                <h:outputLink  value="endedEvents.jsf">
                    Výsledky
                </h:outputLink>
            </li>
            <li>
                <h:form>
                    <h:commandLink value="Odhlásit" action="#{default.logout}"/>
                </h:form>
            </li>
        </ul>
        <h1>Volení</h1>
    </div>
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
