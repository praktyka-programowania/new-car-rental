<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>


<div class="page-header">
    <h1>Registration page</h1>
</div>

<div class="col-md-4">

    <form:form commandName="client" action="/singup" method="post">

        <div class="page-header">
            <h2>
                Personal information:
            </h2>
        </div>

        <fieldset class="form-group">

            <form:label path="firstName">First name:</form:label>
            <form:input path="firstName" type="text" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="lastName">Last name:</form:label>
            <form:input path="lastName" type="text" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">

            <form:label path="age">Age:</form:label>
            <form:input path="age" type="number" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="age" cssClass="text-danger"/>
        </fieldset>


        <div class="page-header">
            <h2>
                Credentials:
            </h2>
        </div>

        <fieldset class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input path="email" type="email" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="email" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="username">Username:</form:label>
            <form:input path="username" type="text" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="username" cssClass="text-danger"/>
        </fieldset>


        <fieldset class="form-group">
            <form:label path="password">Password:</form:label>
            <form:input path="password" type="password" required="required" cssClass="form-control"/>
            <form:errors path="password" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">
            <label>Confirm password:</label>
            <input id="pass" name="pass" type="password" required="required" class="form-control"/>
            <errors cssClass="text-danger"/>
        </fieldset>

        <input type="submit" value="Submin" class="btn btn-success">
    </form:form>

</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
