<%@include file="/WEB-INF/views/common/header.jspf"%>

<div class="row">
    <div class="col-md-3">
        <img src="/resources/books/${car.id}.png" onerror="this.src='/resources/cars/default.png'" alt="Car: ${car.name}" width="250" height="250"/>
    </div>
    <div class="col-md-8">
        <ul style="list-style-type: none;">
            <li> <h3>${book.name}</h3> </li>
            <li> <h4>${book.autor}</h4> </li>
            <li> <a href="/books/genres/${book.genre}"><h4>#${book.genre}</h4></a> </li>
            <li>   <c:choose>
                <c:when test="${book.desc != null && book.desc.length() > 0}">
                    <h3>Short description:</h3>
                    <p><i>${book.desc}</i></p>
                </c:when>
                <c:otherwise>
                    <h3>No book description</h3>
                </c:otherwise>
            </c:choose>
            </li>
            <li><h3>&#36;${book.price}</h3></li>
            <li>
                <a href="#" class="btn btn-warning btn-large"
                   ng-click="addToCart('${book.id}')">Add to cart</a>
                <a href="/books/" class="btn btn-default">Go to all books</a>
            </li>
        </ul>
    </div>
</div>

<%@include file="/WEB-INF/views/common/footer.jspf"%>
