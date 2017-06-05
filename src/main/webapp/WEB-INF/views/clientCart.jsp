<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">

    <h1>
        Client cart:
    </h1>

</div>


<div class="container">
    <br>
    <c:choose>

        <c:when test="${list.size() == 0}">
                <h1>Your history is empty</h1>
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead>
                <th>Client:</th>
                <th>Car:</th>
                <th>Date:</th>
                <th>Returning date:</th>
                <th>Price:</th>
                </thead>
                <tbody>
                <c:forEach var="order" items="${list}">
                    <tr>
                        <td>${order.client.firstName} ${order.client.lastName}</td>
                        <td>${order.client.car.company} ${order.client.car.model} ${order.client.car.year}</td>
                        <td>${order.date}</td>
                        <td>${order.returningDate}</td>
                        <td>${order.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>

    </c:choose>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
