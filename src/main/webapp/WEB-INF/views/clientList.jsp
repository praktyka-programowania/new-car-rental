<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Clients:</h1>
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
        <th>Name:</th>
        <th>Surname:</th>
        <th>Age:</th>
        <th>Email:</th>
        <th>Username:</th>
        <th>Car:</th>
        </thead>
        <tbody>
        <c:forEach var="client" items="${list}">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.age}</td>
                <td>${client.email}</td>
                <td>${client.username}</td>
                <c:choose>
                    <c:when test="${client.car == null}">
                        <td>
                            ---
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>${client.car.id} ${client.car.company} ${client.car.model}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>