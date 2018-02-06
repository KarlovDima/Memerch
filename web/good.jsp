<%@ page import="models.Good" %>
<%@ page import="models.Clothes" %>
<%@ page import="models.Cutlery" %>
<%@ page import="models.Trifle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../stylesheets/goods-page.css">
    <title>GOOD</title>
</head>
<body>
<jsp:include page="header.html"/>

<%
    Good good = (Good) request.getAttribute("good");
    String parameter = "";
    switch (good.getCategory()) {
        case "clothes":
            parameter = "Size: " + ((Clothes) good).getSize();
            break;
        case "cutlery":
            parameter = "Volume: " + ((Cutlery) good).getVolume();
            break;
        case "trifle":
            parameter = "Amount: " + ((Trifle) good).getAmount();
            break;
    }
%>

<br/><br/>
<table align="center">
    <tr>
        <td rowspan="6" valign="top"><img src="<%=good.getMem()%>"/></td>
        <td class="name"><%=good.getName()%>
        </td>
    </tr>
    <tr>
        <td class="parameter">Producer: <%=good.getProducer()%>
        </td>
    </tr>
    <tr>
        <td class="parameter">Price: <%=good.getPrice()%>₴</td>
    </tr>
    <tr>
        <td class="parameter">Material: <%=good.getMaterial()%>
        </td>
    </tr>
    <tr>
        <td class="parameter"><%=parameter%>
        </td>
    </tr>
</table>
</body>
</html>
