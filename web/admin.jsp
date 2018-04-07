<%@ page import="models.Good" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheets/admin.css">

    <title>ADMIN</title>
</head>
<body>
<jsp:include page="admin-header.html"/>
<br/><br/>
<table align="center">
    <tr>
        <td>
            <form action="admin">
                Search:
                <input type="search" name="searching">
                <input type="submit" value="Start">
            </form>
        </td>
        <td>
            <form action="admin">
                Sort by name:
                <select name="sorting" class="parameter">
                    <option value="descending">descending</option>
                    <option value="ascending">ascending</option>
                </select>
                <input type="submit" value="Sort">
            </form>
        </td>
        <td>
            <form action="add">
                Category:
                <select name="category" class="parameter">
                    <option value="cutlery">Cutlery</option>
                    <option value="clothes">Clothes</option>
                    <option value="trifle">Trifle</option>
                </select>
                <input type="submit" value="Add">
            </form>
        </td>
    </tr>
    <%
        List<Good> goods = (List<Good>) request.getAttribute("goods");
        for (Good good : goods) {
            out.println("<tr>\n" +
                    "<td><img src=\"" + good.getMem() + "\"></td>\n" +
                    "<td><a href=\"/edit?category=" + good.getCategory() + "&id=" + good.getId() + "\">" + good.getName() + "</a></td>\n" +
                    "<td><a href=\"/delete?category=" + good.getCategory() + "&id=" + good.getId() + "\">Delete</a></td>\n" +
                    "</tr>");
        }
    %>

</table>
</body>
</html>
