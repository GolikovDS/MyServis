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
    <jsp:useBean id="deviceUPT" class="java.util.ArrayList" scope="request">
        <jsp:setProperty name="devise_UPT" property="name"
                         value="<%=request.getAttribute(\"deviceUPT\")%>"/>
    </jsp:useBean>
    <c:forEach items="${deviceUPT}" var="device_UPT_table">
        <tr>
            <td><label for="cbTablePPKPU">${device_UPT_table.name}</label></td>
            <td>${device_UPT_table.number}</td>
            <td>${device_UPT_table.dataManuf}</td>
            <td>${device_UPT_table.idOrderList}</td>
            <td><input type="checkbox" id="cbTablePPKPU"/></td>
        </tr>
    </c:forEach>
</table>
