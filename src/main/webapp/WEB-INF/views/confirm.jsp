<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>


<div class="page-header">
    <h1>
        Confirm your purchase:
    </h1>
</div>

<div class="col-md-4">

    <form:form action="/order/confirm" method="post">

        <fieldset class="form-group">
            <label>Name: </label>
            <h5>${client.firstName} ${client.lastName}</h5>
            <input type="hidden" name="client_id" value="${client.id}">
        </fieldset>

        <fieldset class="form-group">
            <label>Car: </label>
            <h5>${car.company} ${car.model}</h5>
            <h5>${car.year}</h5>
            <input type="hidden" name="car_id" value="${car.id}">
        </fieldset>

        <fieldset class="form-group">
            <label>Price: </label>
            <h5>&#36;${price}</h5>
            <input type="hidden" name="price" value="${price}">
        </fieldset>

        <fieldset class="form-group">
            <label>Returning date: </label>
            <h5>${date}</h5>
            <input type="hidden" name="date" value="${date}">
        </fieldset>

        <div class="row">
            <div class="col-md-1">
                <input type="submit" value="Confirm" class="btn btn-primary">
            </div>
            <div class="col-md-1" style="margin-left: 65px;">
                <a href="/cars/${car.id}" class="btn btn-default">Cancel</a>
            </div>
        </div>
    </form:form>

</div>



<%@include file="/WEB-INF/views/common/footer.jspf"%>


