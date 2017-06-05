<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Orders:</h1>
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
        <th>Client:</th>
        <th>Car:</th>
        <th>Date:</th>
        <th>Returning date:</th>
        <th>Price:</th>
        </thead>
        <tbody>
        <c:forEach var="order" items="${list}">
            <tr>
                <td>${order.id}</td>
                <td>${order.client.firstName} ${order.client.lastName}</td>
                <td>${order.client.car.company} ${order.client.car.model} ${order.client.car.year}</td>
                <td>${order.date}</td>
                <td>${order.returningDate}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>