<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.gds.entitys.DeviceEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.gds.entitys.OrderListEntity" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setBundle basename="languages.message"/>
<html>
<head>
    <link href="resources/css/slider/templatemo_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="resources/css/slider/coda-slider.css" type="text/css" charset="utf-8"/>
    <link rel="stylesheet" href="resources/css/slider/tableStyle.css" type="text/css" charset="utf-8"/>

    <script src="resources/js/jquery-1.2.6.js" type="text/javascript"></script>
    <script src="resources/js/jquery.scrollTo-1.3.3.js" type="text/javascript"></script>
    <script src="resources/js/jquery.localscroll-1.2.5.js" type="text/javascript" charset="utf-8"></script>
    <script src="resources/js/jquery.serialScroll-1.2.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="resources/js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
    <script src="resources/js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>


    <title>ENTER</title>

</head>
<body>

<div style="width: 100%; height: 50px; background-color: #0066CC">
    <%--<div id="sitetite">--%>
    <%--<h1><img src="resources/images/mainform/templatemo_logo.png" alt="free css template"/></h1>--%>
    <%--</div>--%>

    <table>
        <tr>
            <td>
                <p style="color: #ff2f05; padding-left: 10px;">
                    <fmt:message key="PPKPU"/> <%=Locale.getDefault().getLanguage()%>

                </p>
            </td>
            <td>
                <form action="logout.do" method="post">
                    <input type="submit" name="btnCloseSession" value="CLOSE SESSION">
                </form>
            </td>
            <td>
                <form action="selected" method="post">
                    <input type="submit" name="btnRu" value="Ru">
                    <input type="submit" name="btnEn" value="En">
                </form>

            </td>
            <td>
                <p style="color: #ff5213;">Пользователь - ${requestScope.get("userName")}</p>
            </td>
        </tr>
    </table>

</div>

<%---- ADD ORDER--%>
<%--<div class="left_panel">--%>
<div style="position: absolute; top: 72px; left: 10px; background-color: rgba(104, 205, 255, 0.32); height: 780px; width: 600px">

    <%--<div class="append_order">--%>
    <div style="
    position: absolute;
    left:25px;
    top: 5px;
    width: 480px;
    height: 100px;
    background-color: rgba(175, 248, 69, 0.73);
    -webkit-box-shadow: -15px 15px 14px 0 rgba(102, 145, 40, 0.55);
    -moz-box-shadow:    -15px 15px 14px 0 rgba(102, 145, 40, 0.55);
    box-shadow:         -15px 15px 14px 0 rgba(102, 145, 40, 0.55);
    z-index: 5;">
        <form action="addOrder" method="post">
            <table>
                <thead style="font-size: 10px">
                <tr>
                    <th>№ заказа</th>
                    <th>Организация</th>
                    <th>Сроки</th>
                    <th>ППКПК</th>
                    <th>УПТ</th>
                    <th>УПС</th>
                    <th>УДУ</th>
                    <th>УСТ</th>
                </tr>
                </thead>
                <tr>
                    <th>
                        <input type="number" name="orderNumbInputText" min="0" style="width: 55px;" value="0000"
                               title=""/>
                    </th>
                    <th>
                        <input type="text" name="orderNameInputText" style="width: 80px;" title="0000" value="ООО"/>
                    </th>
                    <th>
                        <input type="date" name="orderDeadLineInputText" max="2050-04-20" min="2016-04-10"
                               value="2016-11-10" title="0"/>
                    </th>
                    <th><input type="number" name="orderPPKPUInputText" style="width: 30px;" value="0"
                               title="0000"/>
                    </th>
                    <th><input type="number" name="orderUPTInputText" style="width: 30px;" value="0"
                               title="0000"/>
                    </th>
                    <th><input type="number" name="orderUPSInputText" style="width: 30px;" value="0"
                               title="0000"/>
                    </th>
                    <th><input type="number" name="orderUDUInputText" style="width: 30px;" value="0"
                               title="0000"/>
                    </th>
                    <th><input type="number" name="orderUSTInputText" style="width: 30px;" value="0"
                               title="0000"/>
                    </th>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Добавить" name="btnAddOrder"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <%--DELETE ORDER--%>
    <%--<div style="--%>
    <%--position: absolute;--%>
    <%--left:425px;--%>
    <%--top: 20px;--%>
    <%--width: 150px;--%>
    <%--height: 80px;--%>
    <%--padding: 10px 10px 10px 10px;--%>
    <%--background-color: rgba(251, 0, 133, 0.68);--%>
    <%---webkit-box-shadow: -15px 15px 14px 0 rgba(125, 22, 255, 0.40);--%>
    <%---moz-box-shadow:    -15px 15px 14px 0 rgba(125, 0, 255, 0.40);--%>
    <%--box-shadow:         -15px 15px 14px 0 rgba(125, 0, 255, 0.40);--%>
    <%--z-index: 5;">--%>
    <%--<form action="enter.jsp" method="post">--%>
    <%--<input type="number" name="numberOrderToDelete"><br/>--%>
    <%--<input type="submit" value="Удалить" name="btnDeleteOrder">--%>
    <%--</form>--%>
    <%--</div>--%>

    <%--SEARCH ORDER--%>

    <div style="
    position: absolute;
    left:42px;
    top: 85px;
    width: 560px;
    height: 160px;
    padding: 10px 10px 10px 10px;
    background-color: rgba(0, 251, 190, 0.54);
    -webkit-box-shadow: -15px 15px 14px 0 rgba(0, 110, 96, 0.50);
    -moz-box-shadow:    -15px 15px 14px 0 rgba(0, 110, 96, 0.50);
    box-shadow:         -15px 15px 14px 0 rgba(0, 110, 96, 0.50);
    z-index: 5;">
        <p>ПОИСК</p>

        <form action="addOrder" method="post">
            <table>
                <thead style="font-size: 10px">
                <tr>
                    <th>№ заказа</th>
                    <th>Организация</th>
                </tr>
                </thead>
            </table>

            <tr>
                <th>
                    <input type="number" name="orderNumbInputText" min="0" style="width: 55px;" value="0000"
                           title=""/>
                </th>
                <th>
                    <input type="text" name="orderNameInputText" style="width: 80px;" title="0000" value="ООО"/>
                </th>

            </tr>
            <tr>
                <td>
                    <input type="submit" value="Найти" name="btnSearchOrder"/>
                </td>
            </tr>
            </table>
        </form>
    </div>

    <div style="position: absolute; bottom: 5px; left: 10px; height: 500px; right: 5px; background-color: rgba(81, 219, 125, 0.01); padding-top: 25px;">
        <jsp:useBean id="order" class="java.util.ArrayList" scope="request">
            <jsp:setProperty name="order" property="name"
                             value="<%=request.getAttribute(\"order\")%>"/>
        </jsp:useBean>
        <table class="bordered">
            <thead style="font-size: 12px; color: #2ecc17; height: 25px">
            <td width="45">№</td>
            <td width="130">Заказчик</td>
            <td width="55">Срок изг.</td>
            <td style="font-size: 8px; min-width: 15px; max-width: 15px;">ППКПУ</td>
            <td width="15" style="font-size: 8px">УПТ</td>
            <td width="15" style="font-size: 8px">УПС</td>
            <td width="15" style="font-size: 8px">УДУ</td>
            <td width="15" style="font-size: 8px">УСТ</td>
            <td width="15" style="font-size: 8px">Д</td>
            </thead>
        </table>
        <table class="bordered" style="width: 560px">

            <tbody style="font-size: 12px; color: #3b0084; display: block; height: 420px; overflow-y: auto;">
            <c:forEach var="orderFor" items="${order}">
                <tr>
                    <td style="min-width: 45px; max-width: 45px">${orderFor.number}</td>
                    <td style="min-width: 130px; max-width: 130px">${orderFor.nameCostumer}</td>
                    <td style="min-width: 55px; max-width: 55px">${orderFor.dataDeathLine}</td>
                    <td style="min-width: 15px; max-width: 15px">${orderFor.ppkpuPieces}</td>
                    <td style="min-width: 15px; max-width: 15px">${orderFor.uptPieces}</td>
                    <td style="min-width: 15px; max-width: 15px">${orderFor.upsPieces}</td>
                    <td style="min-width: 15px; max-width: 15px">${orderFor.uduPieces}</td>
                    <td style="min-width: 15px; max-width: 15px">${orderFor.ustPieces}</td>
                    <td style="min-width: 15px; max-width: 15px"><input type="checkbox"/></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>


<div id="slider">
    <div id="header">
        <ul class="navigation">
            <li><a href="#order">ППКПУ</a></li>
            <li><a href="#UPT">УПТ</a></li>
            <li><a href="#aboutus">УПС</a></li>
            <li><a href="#services">УДУ</a></li>
            <li><a href="#gallery">УСТ</a></li>
            <li><a href="#contactus">Другое</a></li>
            <li><a href="#contactus">Рекламации</a></li>
            <li><a href="#contactus">Комплект.</a></li>
        </ul>
    </div>


    <div class="scroll">
        <div class="scrollContainer">
            <div class="panel" id="order">
                <jsp:include page="table_ppkpu.jsp"/>
            </div>
            <div class="panel" id="UPT">
                <jsp:include page="table_upt.jsp"/>
            </div>

            <div class="panel" id="aboutus">
                <jsp:include page="table_ups.jsp"/>
            </div>

            <div class="panel" id="services">
                <jsp:include page="table_udu.jsp"/>
            </div>

            <div class="panel" id="gallery">
                <jsp:include page="table_ust.jsp"/>
            </div>

            <div class="panel" id="contactus">
                dsvdsvzsdvs
            </div>
        </div>
    </div>
</div>
<div class="panel_add_device">
    wfewf
</div>
</div>

</body>
</html>
