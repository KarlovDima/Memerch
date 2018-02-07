<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="stylesheets/add.css">
    <title>ADD</title>
</head>
<body>
<jsp:include page="admin-header.html"/>
<br/><br/>

<form action="add">
    <input type="hidden" name="category" value="<%=request.getParameter("category")%>">
    <table align="center">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" class="parameter"></td>
        </tr>
        <tr>
            <td>Producer:</td>
            <td><input type="text" name="producer" class="parameter">
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" class="parameter">₴
            </td>
        </tr>
        <tr>
            <td>Material:</td>
            <td><input type="text" name="material" class="parameter">
            </td>
        </tr>
        <tr>
            <td>Mem:</td>
            <td><input type="url" name="mem" class="parameter"></td>
        </tr>
        <tr>
            <td><%=request.getAttribute("parameterName")%>:</td>
            <td><input type="text" name="parameter" class="parameter">
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="OK"></td>
        </tr>
    </table>
</form>
</body>
</html>