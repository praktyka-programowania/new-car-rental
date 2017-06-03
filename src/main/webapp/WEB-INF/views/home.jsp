<html>
<head>
    <meta charset="utf-8">
    <link rel="icon" href="/resources/img/favicon.ico">

    <title>Car rental store</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">


    <!-- Theme CSS -->
    <link href="/resources/css/freelancer.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

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
                <li class="active"><a href="/login">Login</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<!-- Header -->
<header>
    <div class="container" id="maincontent" tabindex="-1">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="/resources/img/main.png" alt="">
                <div class="intro-text">
                    <h1 class="name">Car rental store</h1>
                    <hr class="star-light">
                    <span class="skills"></span>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="row">
    <div class="col-md-6 text-center well" style="height: 50%; border-style: none; border-radius: 0;">
        <img class="img-circle" height="250" width="250" src="/resources/img/search.png" alt="Search">
        <h2 class="text-success" style="margin-top: 40px;">
            <a href="/search">Go searching</a>
        </h2>
    </div>
    <div class="col-md-6 text-center well" style="height: 50%; border-style: none; border-radius: 0;">
        <img class="img-circle" height="250" width="250" src="/resources/img/list.png" alt="Display all">
        <h2 class="text-success" style="margin-top: 40px;">
            <a href="/cars/">Show all available</a>
        </h2>
    </div>
</div><!--/row-->



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="/resources/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>

