<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>Confirm your purchase:</h1>
</div>

<div class="row">
    <div class="col-md-3">
        <img src="/resources/books/${car.id}.png" onerror="this.src='/resources/cars/default.png'" alt="Car: ${car.id}" width="250" height="250"/>
    </div>
    <div class="col-md-8">
        <ul style="list-style-type: none;">
            <li> <h2>${car.company}</h2> </li>
            <li> <h3>${car.model}</h3> </li>
            <li> <h3>${car.year}</h3> </li>
            <li><h2>&#36;${car.price}</h2></li>
            <li class="pull-right">
                <table>
                    <tr>
                        <td>
                            <form:form action="/order/${car.id}" method="post">
                                <h1>Date: </h1>
                                <input type="text" id="datepicker" name="calendar">
                                <input type="hidden" value="${car.id}">
                                <input class="btn btn-success" type="submit" value="Rent">
                            </form:form>
                        </td>
                        <td>
                            <a href="/cars/" class="btn btn-default">Go to all cars</a>
                        </td>
                    </tr>
                </table>
            </li>
        </ul>
    </div>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
