<%@ page import="models.Good" %>
<%@ page import="models.Clothes" %>
<%@ page import="models.Cutlery" %>
<%@ page import="models.Trifle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GOOD</title>
</head>
<body>
<jsp:include page="header.html"/>
<br/><br/>
<table align="center">
    <tr>
        <%
            Good good = (Good) request.getAttribute("good");
            /*switch (good.getCategory()) {
                case "clothes":
                    Clothes clothes = (Clothes) good;
                    break;
                case "cutlery":
                    Cutlery cutlery = (Cutlery) good;
                    break;
                case "trifle":
                    Trifle trifle = (Trifle) good;
                    break;
            }*/

        %>
        <td rowspan="6"><img src="<%=good.getMem()%>"/></td>
        <td><h2><%=good.getName()%>
        </h2></td>
    </tr>
</table>
</body>
</html>
