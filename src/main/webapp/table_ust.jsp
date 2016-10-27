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
    <jsp:useBean id="deviceUST" class="java.util.ArrayList" scope="request">
        <jsp:setProperty name="devise_UST" property="name"
                         value="<%=request.getAttribute(\"deviceUST\")%>"/>
    </jsp:useBean>
    <c:forEach items="${deviceUST}" var="device_UST_table">
        <tr>
            <td><label for="cbTablePPKPU">${device_UST_table.name}</label></td>
            <td>${device_UST_table.number}</td>
            <td>${device_UST_table.dataManuf}</td>
            <td>${device_UST_table.idOrderList}</td>
            <td><input type="checkbox" id="cbTablePPKPU"/></td>
        </tr>
    </c:forEach>
</table>
