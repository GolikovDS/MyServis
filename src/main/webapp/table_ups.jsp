<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="bordered">
    <thead>
    <tr>
        <th scope="col">Наименование</th>
        <th scope="col">Номер</th>
        <th scope="col">Дата выпуска</th>
        <th scope="col">Номер заказа</th>
        <th scope="col">Выбрать</th>
    </tr>
    </thead>
    <jsp:useBean id="deviceUPS" class="java.util.ArrayList" scope="request">
        <jsp:setProperty name="devise_UPS" property="name"
                         value="<%=request.getAttribute(\"deviceUPS\")%>"/>
    </jsp:useBean>
    <c:forEach items="${deviceUPS}" var="device_UPS_table">
        <tr>
            <td><label for="cbTablePPKPU">${device_UPS_table.name}</label></td>
            <td>${device_UPS_table.number}</td>
            <td>${device_UPS_table.dataManuf}</td>
            <td>${device_UPS_table.idOrderList}</td>
            <td><input type="checkbox" id="cbTablePPKPU"/></td>
        </tr>
    </c:forEach>
</table>
