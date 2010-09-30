<%-- 
    Document   : login
    Created on : 10.11.2009, 21:32:55
    Author     : lordondrak
--%>

<jsp:include page="header.jsp">
  <jsp:param name="title" value="E-volby" />
</jsp:include>
  <div class="login"><div>
        <h1>Login</h1>
        <form action="j_security_check">
          <table class="login">
            <tbody>
              <tr>
                <th>Username:</th><td><input type="text" name="j_username"/></td>
              </tr>
              <tr>
                <th>Password:</th><td><input type="password" name="j_password"/></td>
              </tr>
              <tr>
                <td colspan="2">
                  <input type="submit" value="login"/>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
</div></div>
<jsp:include page="footer.jsp"/>