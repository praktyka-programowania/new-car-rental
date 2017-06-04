<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="page-header">

    <h1>Searching page: </h1>

</div>


<div class="col-md-4">

    <form:form commandName="car" method="post">

        <fieldset class="form-group">
            <form:label path="company">Company:</form:label>
            <form:select path="company" id="companyForm" cssClass="form-control">
                <option value="" selected="selected">---</option>
                <c:forEach var="car" items="${list}">
                    <form:option value="${car.company}">${car.company}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="company" cssClass="text-warning"/>
        </fieldset>


        <fieldset class="form-group">
            <form:label path="model">Model:</form:label>
            <form:select path="model" id="modelForm" cssClass="form-control">
                <option value="" selected="selected">---</option>
                <c:forEach var="car" items="${list}">
                    <form:option value="${car.model}" data-chained="${car.company}">${car.model}</form:option>
                </c:forEach>
            </form:select>
        </fieldset>


        <fieldset class="form-group">
            <form:label path="year">Year:</form:label>
            <form:select path="year" id="yearForm" cssClass="form-control">
                <option value="0" selected="selected">---</option>
                <% for (int i = 2000; i < 2018; ++i) { %>
                <form:option value="<%= i%>"><%= i%></form:option>
                <%}%>
            </form:select>
        </fieldset>

        <input type="submit" class="btn btn-primary" value="Go searching">
    </form:form>

</div>

</div>
<script src="/resources/js/jquery-1.11.3.min.js"></script>
<script src="/resources/js/jquery.chained.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script>
    $(document).ready(
        function()
        {
            var previousOption;
            $('#companyForm option').each(function() {

                thisOption = this.text;
                if (this.text == previousOption) $(this).remove();
                previousOption= this.text;
            });


            $('#modelForm option').each(function() {

                thisOption = this.text;
                if (this.text == previousOption) $(this).remove();
                previousOption= this.text;
            });

            $("#modelForm").chained("#companyForm");
        });
</script>
</body>
</html>
