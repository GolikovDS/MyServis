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
                <p style="color: #ff2f05; padding-left: 10px;"><fmt:message
                        key="PPKPU"/> <%=Locale.getDefault().getLanguage()%>
                </p>
            </td>
            <td>
                <form action="logout.do" method="post">
                    <input type="submit" name="btnCloseSession" value="CLOSE SESSION">
                </form>
            </td>
            <td>

                <label>
                    <select name="select" onchange="window.location.href = '/selected';">
                        <option>Рус</option>
                        <option>En</option>
                    </select>
                </label>

            </td>
        </tr>
    </table>

</div>


<div id="templatemo_wrapper">
    <div id="slider_left">
        <div class="scroll_left">
            <div class="scrollContainer_left">
                <div class="panel_left" id="order_left">
                    ППКПУ
                    <jsp:useBean id="order" class="java.util.ArrayList" scope="request">
                        <jsp:setProperty name="order" property="name"
                                         value="<%=request.getAttribute(\"order\")%>"/>
                    </jsp:useBean>
                    <table class="bordered">
                        <c:forEach var="orderFor" items="${order}">
                            <tr>
                                <td>${orderFor.number}</td>
                                <td>${orderFor.nameCostumer}</td>
                                <td>${orderFor.dataDeathLine}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="panel_left" id="component_left">
                    Детали
                </div>
            </div>
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
</div>

</body>
</html>
