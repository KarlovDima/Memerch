<%@ page import="models.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../stylesheets/goods-page.css">
    <title>EDIT</title>
</head>
<body>
<jsp:include page="admin-header.html"/>

<%
    Good good = (Good) request.getAttribute("good");
    String parameterName = "";
    String parameterValue = "";
    switch (good.getCategory()) {
        case "clothes":
            parameterName = "Size: ";
            parameterValue = ((Clothes) good).getSize();
            break;
        case "cutlery":
            parameterName = "Volume: ";
            parameterValue = ((Cutlery) good).getVolume();
            break;
        case "trifle":
            parameterName = "Amount: ";
            parameterValue = String.valueOf(((Trifle) good).getAmount());
            break;
    }
%>

<br/><br/>

<form action="edit">
    <input type="hidden" name="category" value=<%=good.getCategory()%>>
    <input type="hidden" name="id" value=<%=good.getId()%>>
    <table align="center">
        <tr>
            <td rowspan="5" valign="top"><img src="<%=good.getMem()%>"/></td>
            <td><input type="text" name="name" value="<%=good.getName()%>" class="name"></td>
        </tr>
        <tr>
            <td class="parameter">Producer: <input type="text" name="producer" value="<%=good.getProducer()%>"
                                                   class="parameter">
            </td>
        </tr>
        <tr>
            <td class="parameter">Price: <input type="text" name="price" value="<%=good.getPrice()%>" class="parameter">₴
            </td>
        </tr>
        <tr>
            <td class="parameter">Material: <input type="text" name="material" value="<%=good.getMaterial()%>"
                                                   class="parameter">
            </td>
        </tr>
        <tr>
            <td class="parameter"><%=parameterName%><input type="text" name="parameter" value="<%=parameterValue%>" class="parameter">
            </td>
        </tr>
        <tr>
            <td align="center"><input type="url" name="mem" value="<%=good.getMem()%>" class="parameter" size="35"></td>
            <td align="right"><input type="submit" value="OK" class="parameter"></td>
        </tr>
    </table>
</form>
</body>
</html>
