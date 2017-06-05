<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>


<div class="page-header">
    <h1>Car information: </h1>
</div>

<div class="col-md-4">

    <form:form commandName="car" method="post">


        <fieldset class="form-group">

            <form:label path="company">Company:</form:label>
            <form:input path="company" type="text" required="required" cssClass="form-control"/>
            <form:errors path="company" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="model">Model:</form:label>
            <form:input path="model" type="text" required="required" cssClass="form-control"/>
            <form:errors path="model" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">

            <form:label path="year">Year:</form:label>
            <form:input path="year" type="number" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="year" cssClass="text-danger"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="price">Price:</form:label>
            <form:input path="price" type="number" required="required" cssClass="form-control inputWithoutSpaces"/>
            <form:errors path="price" cssClass="text-danger"/>
        </fieldset>

        <input type="submit" value="Submit" class="btn btn-success">
    </form:form>

</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>