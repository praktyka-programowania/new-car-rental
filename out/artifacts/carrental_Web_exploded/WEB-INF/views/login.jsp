<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">
    <h1>
        Log in:
    </h1>
</div>


<div class="col-md-4">
    <form:form name="loginForm" action="/j_spring_security_check" method="post">
        <fieldset class="form-group">
            <label>Username: </label>
            <input class="form-control" for="username" id="username" name="username" type="text"/>
            <label>Password: </label>
            <input class="form-control" for="password" id="password" name="password" type="password"/>
            <p class="text-danger">${message}</p>
        </fieldset>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="row">
            <div class="col-md-1">
                <input type="submit" value="Log in" class="btn btn-primary">
            </div>
            <div class="col-md-1" style="margin-left: 45px;">
                <a href="/singup" class="btn btn-primary">Sing up</a>
            </div>
        </div>
    </form:form>
</div>


<%@include file="/WEB-INF/views/common/footer.jspf"%>