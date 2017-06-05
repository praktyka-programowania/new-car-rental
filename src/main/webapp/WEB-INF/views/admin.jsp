<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Admin page:</h1>
</div>
<div class="container">
    <table style="float: right;">
        <tr>
            <td style="padding: 5px;"><a href="/admin/add" class="btn btn-primary">Add car</a></td>
            <td style="padding: 5px;"><a href="/cars/" class="btn btn-primary">Show cars</a></td>
            <td style="padding: 5px;"><a href="/admin/clients" class="btn btn-primary">Show clients</a></td>
            <td style="padding: 5px;"> <a href="/admin/orders" class="btn btn-primary">Show orders</a></td>
        </tr>
    </table>
    <br>
    <table class="table table-striped">
        <thead>
        <th>ID:</th>
        <th>Company:</th>
        <th>Model:</th>
        <th>Year:</th>
        <th>Price:</th>
        <th>Returning date:</th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="car" items="${list}">
            <tr style="${car.enabled == false ? 'color:#ff0000;' : ''}">
                <td>${car.id}</td>
                <td>${car.company}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.price}</td>
                <td>${car.returningDate != null ? car.returningDate : '---'}</td>
                <td>
                    <a href="/admin/update/${car.id}" class="glyphicon glyphicon-pencil"></a>
                </td>
                <td>
                    <a href="/admin/delete/${car.id}" class="glyphicon glyphicon-remove"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>