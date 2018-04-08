<%@ page import="models.Good" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheets/goods-table.css">
    <title>HOME</title>
</head>
<body>
<jsp:include page="header.html"/>
<br/><br/>
<table align="center">
    <tr>
        <td colspan="4" align="right">
            <form action="homepage">
                Sort:
                <select name="sort">
                    <option value="lowToHigh">Price (Low to High)</option>
                    <option value="highToLow">Price (High to Low)</option>
                    <option value="aToZ">Name (A to Z)</option>
                    <option value="zToA">Name (Z to A)</option>
                </select>
                <input type="submit" value="Sort">
            </form>
        </td>
    </tr>
    <tr>
        <%
            List<Good> goods = (List<Good>) request.getAttribute("goods");
            for (Good good : goods) {
                out.println("<td align=\"center\">" +
                        "<a href=\"?category=" + good.getCategory() + "&id=" + good.getId() + "\">" +
                        "<img src=\"" + good.getMem() + "\"/>" +
                        "<br/>" + good.getName() +
                        "<br/>" + good.getPrice() + "₴" +
                        "</a></td>");
                if ((goods.indexOf(good) + 1) % 4 == 0) out.print("</tr><tr>");
            }
        %>
    </tr>
</table>
</body>
</html>
