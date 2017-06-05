<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="icon" href="/resources/img/favicon.ico">

    <title>Car rental store</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="/resources/css/navbar.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="/resources/css/freelancer.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">


    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

    <script>
        var dateToday = new Date();
        dateToday.setDate(dateToday.getDate() + 1);
        $(function() {
            $( "#datepicker" ).datepicker({
                numberOfMonths: 1,
                showButtonPanel: true,
                minDate: dateToday,
                dateFormat: 'dd/mm/yy'
            });
        });
    </script>

</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div style="padding-left: 15px; padding-right: 50px;">
        <div class="navbar-header">
            <a class="navbar-brand">Car rental store</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${pageContext.request.requestURI eq '/WEB-INF/views/home.jsp' ? 'active' : ''}"><a href="/">Home</a></li>
                <li class="${pageContext.request.requestURI eq '/WEB-INF/views/search.jsp' ? 'active' : ''}"><a href="/search">Search</a></li>
                <li class="${pageContext.request.requestURI eq '/WEB-INF/views/about.jsp' ? 'active' : ''}"><a href="/about">About</a></li>
                <li class="${pageContext.request.requestURI eq '/WEB-INF/views/contact.jsp' ? 'active' : ''}"><a href="/contact">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name eq 'admin'}">
                    <li class="active"><a href="/admin/">Manage</a></li>
                </c:if>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="active"><a href="/login">Login</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="active"><a href="/logout">Logout</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
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
            <li><h2>&#36;${car.price} / per month (30 days)</h2></li>
            <h1>Date: </h1>
            <form:form action="/order/${car.id}" method="post">
            <input type="text" required="required" id="datepicker" name="calendar">
            <li class="pull-right">
                <table>
                    <tr>
                        <td>
                            <input type="hidden" value="${car.id}">
                            <input class="btn btn-success" type="submit" value="Rent">
                        </td>
                        <td>
                            <a href="/cars/" class="btn btn-default">Go to all cars</a>
                        </td>
                    </tr>
                </table>
            </li>
            </form:form>
        </ul>
    </div>
</div>

</div> <!-- /container -->

<footer>
    <br>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="/resources/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>


</body>
</html>