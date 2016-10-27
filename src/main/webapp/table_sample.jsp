<%@ page import="ru.gds.entitys.DeviceEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
  <jsp:useBean id="users" scope="request" class="java.util.ArrayList"/>
  <% users = (java.util.ArrayList) request.getAttribute("device");
    for (DeviceEntity deviceEntity : (ArrayList<DeviceEntity>) users) {
  %>
  <tr>
    <td><%=deviceEntity.getName()%>
    </td>
    <td><%=deviceEntity.getNumber()%>
    </td>
  </tr>
  <%}%>
</table>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
