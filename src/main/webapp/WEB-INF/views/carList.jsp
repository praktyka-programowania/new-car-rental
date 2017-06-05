<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>All available cars for you:</h1>
</div>

<div class="container">
    <c:forEach var="car" items="${list}">

        <div class="row" style="height: 150px; margin-top: 5px; background-color: #e9eedb;">
            <div class="col-md-2" style="padding-left: 0px;">
                <img src="/resources/cars/${car.id}.png" onerror="this.src='/resources/cars/default.png'" alt="Car: ${car.id}" width="150" height="150"/>
            </div>
            <div class="col-md-4">
                <h3>${car.company}</h3>
                <h4>${car.model}</h4>
                <h4>${car.year}</h4>
            </div>
            <div class="col-md-2 pull-right" style="text-align: right; padding-top: 2%; padding-right: 2%;">
                <h3>Price: &#36;${car.price}</h3>
                <a class="btn btn-success" href="/cars/${car.id}">View</a>
            </div>
        </div>

    </c:forEach>
</div>



<%@include file="/WEB-INF/views/common/footer.jspf"%>
