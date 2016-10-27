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
    <jsp:useBean id="devicePPKPU" class="java.util.ArrayList" scope="request">
        <jsp:setProperty name="devise_PPKPU" property="name"
                         value="<%=request.getAttribute(\"devicePPKPU\")%>"/>
    </jsp:useBean>
    <c:forEach items="${devicePPKPU}" var="device_PPKPU_table">
        <tr>
            <td><label for="cbTablePPKPU">${device_PPKPU_table.name}</label></td>
            <td>${device_PPKPU_table.number}</td>
            <td>${device_PPKPU_table.dataManuf}</td>
            <td>${device_PPKPU_table.idOrderList}</td>
            <td><input type="checkbox" id="cbTablePPKPU"/></td>
        </tr>
    </c:forEach>
</table>
