<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>


<div class="page-header">
    <h1>
        Contact us:
    </h1>
</div>

<div class="col-md-4">

    <form:form commandName="contact" method="post">

        <fieldset class="form-group">

            <form:label path="firstName">Name: </form:label>
            <form:input path="firstName" type="text" required="required" class="form-control"/>
            <form:errors cssClass="text-danger"/>

        </fieldset>

        <fieldset class="form-group">

            <form:label path="lastName">Surname: </form:label>
            <form:input path="lastName" type="text" required="required" class="form-control"/>
            <form:errors cssClass="text-danger"/>

        </fieldset>

        <fieldset class="form-group">

            <form:label path="email">Email: </form:label>
            <form:input path="email" type="email" required="required" class="form-control"/>
            <form:errors cssClass="text-danger"/>

        </fieldset>
        <fieldset class="form-group">

            <form:label path="message">Message: </form:label>
            <form:textarea path="message" required="required" cssClass="form-control" rows="3" cssStyle="resize: none;"/>
            <form:errors cssClass="text-danger"/>

        </fieldset>

        <input type="submit" value="Send" class="btn btn-primary">
    </form:form>

</div>


<%@include file="/WEB-INF/views/common/footer.jspf"%>


